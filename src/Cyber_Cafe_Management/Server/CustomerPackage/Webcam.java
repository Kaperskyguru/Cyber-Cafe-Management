package Cyber_Cafe_Management.Server.CustomerPackage;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import static org.opencv.imgcodecs.Imgcodecs.imencode;
import org.opencv.videoio.VideoCapture;

/**
 *
 * @author kapersky
 */
public class Webcam extends javax.swing.JDialog {
    
    String img;
    boolean snapshot = true;
    static VideoCapture camera = null;
    Mat frame = new Mat();
    static loadWebcam webcam;
    MatOfByte mem = new MatOfByte();
    BufferedImage buff;
    
    public Webcam(JFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        lblError.setVisible(false);
        btnBrowse.setEnabled(true);
        btnSave.setEnabled(false);
        
        camera = new VideoCapture();
        if (camera.open(1)) {
            webcam = new loadWebcam();
            Thread t = new Thread(webcam, "Webcam");
            t.setDaemon(true);
            webcam.runnable = true;
            t.start();
        } else if (camera.open(0)) {
            webcam = new loadWebcam();
            Thread t = new Thread(webcam, "Webcam");
            t.setDaemon(true);
            webcam.runnable = true;
            t.start();
        } else {
            lblError.setVisible(true);
            btnCapture.setEnabled(false);
            
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paneCamera = new javax.swing.JPanel();
        lblError = new javax.swing.JLabel();
        btnCapture = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnBrowse = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblPhoto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Webcam");
        setAlwaysOnTop(true);

        paneCamera.setBackground(new java.awt.Color(0, 0, 0));
        paneCamera.setMaximumSize(new java.awt.Dimension(0, 0));
        paneCamera.setPreferredSize(new java.awt.Dimension(260, 279));

        lblError.setForeground(new java.awt.Color(255, 51, 51));
        lblError.setText("Webcam not detected");

        javax.swing.GroupLayout paneCameraLayout = new javax.swing.GroupLayout(paneCamera);
        paneCamera.setLayout(paneCameraLayout);
        paneCameraLayout.setHorizontalGroup(
            paneCameraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneCameraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblError)
                .addContainerGap(138, Short.MAX_VALUE))
        );
        paneCameraLayout.setVerticalGroup(
            paneCameraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneCameraLayout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(lblError)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCapture.setText("Capture");
        btnCapture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaptureActionPerformed(evt);
            }
        });

        jLabel2.setText("Webcam");

        jLabel3.setText("Photo");

        btnBrowse.setText("Browse");
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        lblPhoto.setBackground(new java.awt.Color(0, 0, 0));
        lblPhoto.setOpaque(true);
        lblPhoto.setPreferredSize(new java.awt.Dimension(260, 279));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(paneCamera, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(btnCapture)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBrowse)
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancel)
                                .addGap(18, 18, 18))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPhoto, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(btnBrowse))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(paneCamera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(lblPhoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCapture))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSave)
                            .addComponent(btnCancel))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        webcam.runnable = false;
        camera.release();
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseActionPerformed
        JFileChooser d = new JFileChooser();
        if (d.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            img = d.getSelectedFile().toPath().toString();
            ImageIcon icon = new ImageIcon(img);
            lblPhoto.setIcon(ReizeImage(icon));
            btnSave.setEnabled(true);
        }
    }//GEN-LAST:event_btnBrowseActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        ImageIcon icon = (ImageIcon) lblPhoto.getIcon();
        System.out.println(icon.getIconWidth() + ": " + icon.getIconHeight());
        CustomerClass.setImageIconPicture(icon);
        camera.release();
        dispose();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCaptureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaptureActionPerformed
        
        Image i = buff.getScaledInstance((buff.getWidth() / 2) - 62, buff.getHeight() / 2, Image.SCALE_SMOOTH);
        ImageIcon ii = new ImageIcon(i);
        lblPhoto.setIcon(ReizeImage(ii));
        btnSave.setEnabled(true);
        

    }//GEN-LAST:event_btnCaptureActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Webcam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Webcam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Webcam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Webcam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
                Webcam dialog = new Webcam(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        webcam.runnable = false;
                        camera.release();
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowse;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCapture;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblPhoto;
    private javax.swing.JPanel paneCamera;
    // End of variables declaration//GEN-END:variables
class loadWebcam implements Runnable {
        
        protected volatile boolean runnable = false;
        
        @Override
        public void run() {
            synchronized (this) {
                while (true) {
                    
                    if (!camera.isOpened()) {
                        btnBrowse.setEnabled(true);
                        lblError.setVisible(true);
                        btnCapture.setEnabled(false);
                        break;
                        
                    } else if (camera.grab()) {
                        btnBrowse.setEnabled(false);
                        lblError.setVisible(false);
                        btnCapture.setEnabled(true);
                        try {
                            camera.retrieve(frame);
                            imencode(".bmp", frame, mem);
                            Image im = ImageIO.read(new ByteArrayInputStream(mem.toArray()));
                            buff = (BufferedImage) im;
                            Graphics g = paneCamera.getGraphics();
                            g.drawImage(buff, 0, 0, getWidth() - 300, getHeight() - 120, null);
                            
                        } catch (IOException ex) {
                            Logger.getLogger(Webcam.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    }
                }
                
            }
        }
    }
    
    private Icon ReizeImage(ImageIcon icon) {
        Image image = icon.getImage();
        Image image1 = image.getScaledInstance(lblPhoto.getWidth(), lblPhoto.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newicon = new ImageIcon(image1);
        return newicon;
        
    }
}
