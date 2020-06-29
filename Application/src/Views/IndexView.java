
package Views;

import Controllers.IndexerController;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import Models.IndexManager.IndexDataManager.IndexData;
import Models.IndexManager.IndexDataManager;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;


public class IndexView extends javax.swing.JFrame {

    private final IndexerController controller;
    private final JFileChooser openFileChooser;
    private String updateCollectionPath = "";
    private String createCollectionPath = "";
    private String[] indexCollections;
    private DefaultComboBoxModel indexCollectionModel;
    
    
    
    public IndexView() {
        this.controller = new IndexerController(this);
        //Index combo Box
        this.indexCollections = IndexDataManager.getIndexData().getIndexes();
        //File chooser
        this.openFileChooser = new JFileChooser();
        this.openFileChooser.setCurrentDirectory(new File(" "));
        this.openFileChooser.setFileFilter(new FileNameExtensionFilter("txt file", "txt"));
        initComponents();
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        createIndexPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        indexNameField = new javax.swing.JTextField();
        collectionPathField = new javax.swing.JTextField();
        openFileBtn = new javax.swing.JButton();
        createIndexBtn = new javax.swing.JButton();
        createMsgLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        indexingInfoArea = new javax.swing.JTextArea();
        updateIndexPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        updateCollectionPathField = new javax.swing.JTextField();
        updateOpenFileBtn = new javax.swing.JButton();
        UpdateIndexBtn = new javax.swing.JButton();
        updateMsgLabel = new javax.swing.JLabel();
        updateIndexName = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        createIndexPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Index name: ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Create Index");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Collection:");

        indexNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                indexNameFieldActionPerformed(evt);
            }
        });

        openFileBtn.setText("Open file ...");
        openFileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileBtnActionPerformed(evt);
            }
        });

        createIndexBtn.setText("Create");
        createIndexBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createIndexBtnActionPerformed(evt);
            }
        });

        createMsgLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        createMsgLabel.setForeground(new java.awt.Color(153, 0, 0));

        javax.swing.GroupLayout createIndexPanelLayout = new javax.swing.GroupLayout(createIndexPanel);
        createIndexPanel.setLayout(createIndexPanelLayout);
        createIndexPanelLayout.setHorizontalGroup(
            createIndexPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createIndexPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(createIndexPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addGroup(createIndexPanelLayout.createSequentialGroup()
                        .addGroup(createIndexPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, createIndexPanelLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(25, 25, 25)
                                .addComponent(collectionPathField, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, createIndexPanelLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(indexNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(openFileBtn))
                    .addGroup(createIndexPanelLayout.createSequentialGroup()
                        .addComponent(createIndexBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(createMsgLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        createIndexPanelLayout.setVerticalGroup(
            createIndexPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createIndexPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(createIndexPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(indexNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(createIndexPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(collectionPathField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(openFileBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(createIndexPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createIndexBtn)
                    .addComponent(createMsgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Indexing Information");

        indexingInfoArea.setBackground(new java.awt.Color(255, 255, 255));
        indexingInfoArea.setColumns(20);
        indexingInfoArea.setRows(5);
        jScrollPane1.setViewportView(indexingInfoArea);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(303, 303, 303)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                .addContainerGap())
        );

        updateIndexPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Update Index");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Index name: ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Collection:");

        updateCollectionPathField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateCollectionPathFieldActionPerformed(evt);
            }
        });

        updateOpenFileBtn.setText("Open file ...");
        updateOpenFileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateOpenFileBtnActionPerformed(evt);
            }
        });

        UpdateIndexBtn.setText("Update");
        UpdateIndexBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateIndexBtnActionPerformed(evt);
            }
        });

        updateMsgLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        updateMsgLabel.setForeground(new java.awt.Color(153, 0, 0));

        updateIndexName.setModel(this.indexCollectionModel);

        javax.swing.GroupLayout updateIndexPanelLayout = new javax.swing.GroupLayout(updateIndexPanel);
        updateIndexPanel.setLayout(updateIndexPanelLayout);
        updateIndexPanelLayout.setHorizontalGroup(
            updateIndexPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateIndexPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(updateIndexPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(updateIndexPanelLayout.createSequentialGroup()
                        .addGroup(updateIndexPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, updateIndexPanelLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(25, 25, 25)
                                .addComponent(updateCollectionPathField, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, updateIndexPanelLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(updateIndexName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateOpenFileBtn))
                    .addGroup(updateIndexPanelLayout.createSequentialGroup()
                        .addComponent(UpdateIndexBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateMsgLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        updateIndexPanelLayout.setVerticalGroup(
            updateIndexPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateIndexPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(updateIndexPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateIndexName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(updateIndexPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateCollectionPathField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateOpenFileBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(updateIndexPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UpdateIndexBtn)
                    .addComponent(updateMsgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(createIndexPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(updateIndexPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(createIndexPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(updateIndexPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //
    public void addTextIndexingArea(String text){
        this.indexingInfoArea.setText(
            this.indexingInfoArea.getText() + text
        );
    }
    
    public void setTextIndexNameField(String text){
        this.indexNameField.setText(text);
    }
    
    public void setTextCreateMsgLabel(String text){
        this.createMsgLabel.setText(text);
    }
    
    public void setTextUpdateMsgLabel(String text){
        this.updateMsgLabel.setText(text);
    }
    
    public void cleanCreateCollectionPath(){
        this.createCollectionPath = "";
    }
    
    public void cleanUpdateCollectionPath(){
        this.updateCollectionPath = "";
    }
    
    public void cleanIndexingInfoArea(){
        this.indexingInfoArea.setText("");
    }
    
    public void updateIndexCollections(String[] indexes){
        this.indexCollections = indexes;
        if(this.indexCollectionModel == null) 
            this.indexCollectionModel = new DefaultComboBoxModel(this.indexCollections);
        this.indexCollectionModel.removeAllElements();
        for(String index : indexes)
            this.indexCollectionModel.addElement(index);
    }
    
    private void openFileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileBtnActionPerformed
        int returnValue = openFileChooser.showOpenDialog(this);
        if(returnValue == JFileChooser.APPROVE_OPTION){
            this.createCollectionPath = openFileChooser.getSelectedFile().getAbsolutePath();
            this.collectionPathField.setText(this.openFileChooser.getSelectedFile().getName());
        }else{
            this.collectionPathField.setText("");
            this.createMsgLabel.setText("No file choosen!");
        }
    }//GEN-LAST:event_openFileBtnActionPerformed

    private void createIndexBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createIndexBtnActionPerformed
        if(this.indexNameField.getText().isEmpty()){
            this.createMsgLabel.setText("Input a index name");
        }
        else if(this.createCollectionPath.isEmpty()){
            this.createMsgLabel.setText("No file choosen...");
        }
        else{
            //try {
                controller.getHiloIndexador().setIndexName(this.indexNameField.getText());
                controller.getHiloIndexador().setCollectionPath(createCollectionPath);
                controller.getHiloIndexador().setUpdating(false);
                controller.getHiloIndexador().startIndexing();
                //controller.createIndex(this.indexNameField.getText(), createCollectionPath);

                
            //} catch (IOException ex) {
               // this.indexingInfoArea.setText("Error al indexar: " + ex.getMessage());
                //Logger.getLogger(IndexView.class.getName()).log(Level.SEVERE, null, ex);
            //}
        }
    }//GEN-LAST:event_createIndexBtnActionPerformed

    private void updateOpenFileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateOpenFileBtnActionPerformed
        int returnValue = openFileChooser.showOpenDialog(this);
        if(returnValue == JFileChooser.APPROVE_OPTION){
            this.updateCollectionPath = openFileChooser.getSelectedFile().getAbsolutePath();
            this.updateCollectionPathField.setText(this.openFileChooser.getSelectedFile().getName());
        }else{
            this.updateCollectionPathField.setText("");
            this.updateMsgLabel.setText("No file choosen!");
        }
    }//GEN-LAST:event_updateOpenFileBtnActionPerformed

    private void UpdateIndexBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateIndexBtnActionPerformed
        String indexName = this.updateIndexName.getSelectedItem().toString();
        if(indexName.isEmpty()){
            this.updateMsgLabel.setText("Select an index");
        }
        else if(this.updateCollectionPath.isEmpty()){
            this.updateMsgLabel.setText("No file choosen...");
        }
        else{
            //try {
                controller.getHiloIndexador().setIndexName(indexName);
                controller.getHiloIndexador().setCollectionPath(updateCollectionPath);
                controller.getHiloIndexador().setUpdating(true);
                controller.getHiloIndexador().startIndexing();
                //controller.updateIndex(indexName, updateCollectionPath);
                                
            //} catch (IOException ex) {
                //this.indexingInfoArea.setText("Error al indexar: " + ex.getMessage());
                //Logger.getLogger(IndexView.class.getName()).log(Level.SEVERE, null, ex);
            //}
        }
    }//GEN-LAST:event_UpdateIndexBtnActionPerformed

    private void indexNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_indexNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_indexNameFieldActionPerformed

    private void updateCollectionPathFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateCollectionPathFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateCollectionPathFieldActionPerformed

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
            java.util.logging.Logger.getLogger(IndexView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IndexView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IndexView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IndexView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new IndexView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton UpdateIndexBtn;
    private javax.swing.JTextField collectionPathField;
    private javax.swing.JButton createIndexBtn;
    private javax.swing.JPanel createIndexPanel;
    private javax.swing.JLabel createMsgLabel;
    private javax.swing.JTextField indexNameField;
    private javax.swing.JTextArea indexingInfoArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton openFileBtn;
    private javax.swing.JTextField updateCollectionPathField;
    private javax.swing.JComboBox updateIndexName;
    private javax.swing.JPanel updateIndexPanel;
    private javax.swing.JLabel updateMsgLabel;
    private javax.swing.JButton updateOpenFileBtn;
    // End of variables declaration//GEN-END:variables

}
