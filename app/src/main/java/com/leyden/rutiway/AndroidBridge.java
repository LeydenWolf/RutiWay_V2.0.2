// INICIO BLOQUE: AndroidBridge.java v2.0.2 - CON FUNCIÓN PRINT PDF
package com.leyden.rutiway;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.util.Log;
import android.os.Environment;
import android.os.Build;
import android.widget.Toast;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintManager;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AndroidBridge {
    private Context context;
    private WebView webView;
    private static final String TAG = "AndroidBridge";

    public AndroidBridge(Context context, WebView webView) {
        this.context = context;
        this.webView = webView;
        Log.d(TAG, "AndroidBridge inicializado");
    }

    /**
     * ⭐ ABRIR GOOGLE MAPS CON LA RUTA
     */
    // INICIO - NUEVO saveGPX() con carpeta RutiWay y nombre desde JS
    @JavascriptInterface
    public void saveGPX(String gpxContent, String filename) {
        Log.d(TAG, "saveGPX() - Iniciando con nombre: " + filename);

        try {
            // Crear carpeta /Downloads/RutiWay/
            File downloadDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            File rutiWayDir = new File(downloadDir, "RutiWay");
            if (!rutiWayDir.exists()) {
                if (rutiWayDir.mkdirs()) {
                    Log.d(TAG, "Carpeta /Downloads/RutiWay/ creada");
                } else {
                    Log.e(TAG, "Error creando carpeta RutiWay");
                }
            }

            // Usar nombre que pasa JS (ya tiene timestamp)
            File gpxFile = new File(rutiWayDir, filename);
            FileWriter writer = new FileWriter(gpxFile);
            writer.write(gpxContent);
            writer.close();

            Log.d(TAG, "✅ GPX guardado: " + gpxFile.getAbsolutePath());

            // Escanear para que aparezca inmediatamente
            Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
            mediaScanIntent.setData(Uri.fromFile(gpxFile));
            context.sendBroadcast(mediaScanIntent);

            // Toast con ruta completa
            final String path = "/Descargas/RutiWay/" + filename;
            ((MainActivity)context).runOnUiThread(() ->
                    Toast.makeText(context, "Guardado:\n" + path, Toast.LENGTH_LONG).show()
            );

        } catch (IOException e) {
            Log.e(TAG, "❌ Error saveGPX: " + e.getMessage());
            ((MainActivity)context).runOnUiThread(() ->
                    Toast.makeText(context, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show()
            );
        }
    }
// FIN


    /**
     * ⭐ ABRIR URL EN NAVEGADOR
     */
    @JavascriptInterface
    public void openBrowser(String url) {
        try {
            Log.d(TAG, "openBrowser() - URL: " + url);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            context.startActivity(intent);
            Log.d(TAG, "Navegador abierto correctamente");
        } catch (Exception e) {
            Log.e(TAG, "Error al abrir navegador: " + e.getMessage());
        }
    }

    /**
     * ⭐ COMPARTIR RUTA
     */
    @JavascriptInterface
    public void shareRoute(String rutaTexto) {
        try {
            Log.d(TAG, "shareRoute() ejecutándose");
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Mi ruta RutiWay");
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Mira mi ruta en RutiWay:\n\n" + rutaTexto);
            Intent chooser = Intent.createChooser(shareIntent, "Compartir ruta con...");
            context.startActivity(chooser);
        } catch (Exception e) {
            Log.e(TAG, "Error al compartir: " + e.getMessage());
        }
    }

    /**
     * ⭐ GUARDAR GPX
     */
    @JavascriptInterface
    public void saveGPX(String gpxContent) {
        try {
            Log.d(TAG, "saveGPX() ejecutándose");
            File downloadDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            if (!downloadDir.exists()) {
                downloadDir.mkdirs();
            }
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
            File gpxFile = new File(downloadDir, "RutiWay_" + timestamp + ".gpx");
            FileWriter writer = new FileWriter(gpxFile);
            writer.write(gpxContent);
            writer.close();
            Log.d(TAG, "GPX guardado en: " + gpxFile.getAbsolutePath());

            // Mostrar toast de confirmación
            ((MainActivity)context).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(context, "GPX guardado en Descargas", Toast.LENGTH_SHORT).show();
                }
            });
        } catch (IOException e) {
            Log.e(TAG, "Error al guardar GPX: " + e.getMessage());
        }
    }

    /**
     * ⭐ GENERAR PDF (NUEVO)
     * Método para generar PDF desde el WebView en Android
     */
    @JavascriptInterface
    public void print() {
        ((MainActivity)context).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    Log.d(TAG, "print() - Iniciando generación PDF");

                    // Obtener PrintManager
                    PrintManager printManager = (PrintManager) context.getSystemService(Context.PRINT_SERVICE);

                    // Crear nombre del archivo con timestamp
                    String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
                    String jobName = "RutiWay_" + timestamp;

                    // Crear PrintDocumentAdapter desde WebView
                    PrintDocumentAdapter printAdapter = webView.createPrintDocumentAdapter(jobName);

                    // Configurar atributos de impresión
                    PrintAttributes.Builder builder = new PrintAttributes.Builder();
                    builder.setMediaSize(PrintAttributes.MediaSize.ISO_A4);
                    builder.setResolution(new PrintAttributes.Resolution("pdf", "pdf", 600, 600));
                    builder.setMinMargins(PrintAttributes.Margins.NO_MARGINS);

                    // Crear trabajo de impresión
                    printManager.print(jobName, printAdapter, builder.build());

                    Log.d(TAG, "PDF generado correctamente: " + jobName);
                    Toast.makeText(context, "Generando PDF...", Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    Log.e(TAG, "Error al imprimir: " + e.getMessage());
                    Toast.makeText(context, "Error al generar PDF: " + e.getMessage(), Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * ⭐ ENVIAR EMAIL
     */
    @JavascriptInterface
    public void sendEmail(String email, String subject, String body) {
        try {
            Log.d(TAG, "sendEmail() - Destinatario: " + email);
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setType("message/rfc822");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject != null ? subject : "");
            emailIntent.putExtra(Intent.EXTRA_TEXT, body != null ? body : "");
            Intent chooser = Intent.createChooser(emailIntent, "Enviar correo con...");
            context.startActivity(chooser);
        } catch (Exception e) {
            Log.e(TAG, "Error al abrir email: " + e.getMessage());
        }
    }

    /**
     * ⭐ FUNCTION DEBUG
     */
    @JavascriptInterface
    public void log(String message) {
        Log.d(TAG, "JS_LOG: " + message);
    }

    /**
     * ⭐ OBTENER INFO DEL DISPOSITIVO
     */
    @JavascriptInterface
    public String getDeviceInfo() {
        String info = "Dispositivo: " + Build.DEVICE + " | Modelo: " + Build.MODEL +
                " | Android: " + Build.VERSION.RELEASE + " | Fabricante: " + Build.MANUFACTURER;
        Log.d(TAG, info);
        return info;
    }

    /**
     * ⭐ COPIAR AL PORTAPAPELES
     */
    @JavascriptInterface
    public void copyToClipboard(String texto) {
        try {
            android.content.ClipboardManager clipboard =
                    (android.content.ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            android.content.ClipData clip = android.content.ClipData.newPlainText("RutiWay", texto);
            clipboard.setPrimaryClip(clip);
            Log.d(TAG, "Texto copiado al portapapeles");

            // Toast de confirmación
            ((MainActivity)context).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(context, "Copiado al portapapeles", Toast.LENGTH_SHORT).show();
                }
            });
        } catch (Exception e) {
            Log.e(TAG, "Error al copiar: " + e.getMessage());
        }
    }
}
// FIN BLOQUE
