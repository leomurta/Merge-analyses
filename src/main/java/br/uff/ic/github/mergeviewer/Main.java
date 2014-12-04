/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.github.mergeviewer;

import br.uff.ic.gems.merge.utils.KrakenFile;
import br.uff.ic.gems.merge.utils.MergeUtils;
import br.uff.ic.gems.merge.vcs.GitCMD;
import br.uff.ic.github.mergeviewer.ast.ASTExtractor;
import br.uff.ic.github.mergeviewer.processing.InitProject;
import br.uff.ic.github.mergeviewer.processing.ProcessRevision;
import br.uff.ic.github.mergeviewer.processing.Understanding;
import br.uff.ic.github.mergeviewer.util.ConflictingChunk;
import br.uff.ic.github.mergeviewer.util.ContextFinder;
import br.uff.ic.github.mergeviewer.util.Information;
import br.uff.ic.github.mergeviewer.util.Variables;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * @author Gleiph
 */
public class Main extends javax.swing.JFrame {

    private String repositoryPath;
    private InitProject initProject;

    private List<ConflictingChunk> conflicts;

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
//        jScrollPane2.setVisible(false);
//        cbFiles.setVisible(false);
//        btnUnderstand.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelProgress = new javax.swing.JPanel();
        jProgressBar = new javax.swing.JProgressBar();
        jPanelContent = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCont = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaInformation = new javax.swing.JTextArea();
        btnUnderstand = new javax.swing.JButton();
        cbFiles = new javax.swing.JComboBox();
        btnNextConflict = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jCbxConflicts = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Project");

        javax.swing.GroupLayout jPanelProgressLayout = new javax.swing.GroupLayout(jPanelProgress);
        jPanelProgress.setLayout(jPanelProgressLayout);
        jPanelProgressLayout.setHorizontalGroup(
            jPanelProgressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProgressLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelProgressLayout.setVerticalGroup(
            jPanelProgressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProgressLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 15, Short.MAX_VALUE))
        );

        jProgressBar.getAccessibleContext().setAccessibleName("progress");

        jTableCont.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableContMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableCont);

        jtaInformation.setColumns(20);
        jtaInformation.setRows(5);
        jScrollPane1.setViewportView(jtaInformation);

        btnUnderstand.setText("Understand");
        btnUnderstand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnderstandActionPerformed(evt);
            }
        });

        cbFiles.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbFiles.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbFilesItemStateChanged(evt);
            }
        });

        btnNextConflict.setText("Next conflict");
        btnNextConflict.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextConflictActionPerformed(evt);
            }
        });

        jButton1.setText("File diff");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jCbxConflicts.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton2.setText("Show");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelContentLayout = new javax.swing.GroupLayout(jPanelContent);
        jPanelContent.setLayout(jPanelContentLayout);
        jPanelContentLayout.setHorizontalGroup(
            jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelContentLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(btnNextConflict)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelContentLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelContentLayout.createSequentialGroup()
                                .addGroup(jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jCbxConflicts, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbFiles, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnUnderstand)
                                    .addGroup(jPanelContentLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jButton2)))
                                .addContainerGap())))))
        );
        jPanelContentLayout.setVerticalGroup(
            jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelContentLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbFiles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUnderstand))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCbxConflicts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addGroup(jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNextConflict)
                            .addComponent(jButton1)))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        jMenu1.setText("File");

        jMenuItem1.setText("Open repository");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseClicked(evt);
            }
        });
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenuItem1.getAccessibleContext().setAccessibleName("openRepository");

        jMenuItem2.setText("Save");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Open");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Show");

        jMenuItem4.setText("Statistics");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelProgress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanelContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanelProgress.getAccessibleContext().setAccessibleName("JPanelProgress");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenuItem1MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:

        initProject = new InitProject(jProgressBar, jTableCont, jMenu1);

        Thread run = new Thread(initProject);
        run.start();

        jScrollPane2.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jTableContMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableContMouseClicked
        // TODO add your handling code here:
        TableModel model = jTableCont.getModel();
        String revision = model.getValueAt(jTableCont.getSelectedRow(), 0).toString();
        String status = model.getValueAt(jTableCont.getSelectedRow(), 1).toString();

        Information.STATUS = status;
        Information.DEVELOPER_MERGE_REVISION = revision;

        if (initProject != null) {
            repositoryPath = initProject.getRepositoryPath();
        }

        ProcessRevision processRevision = new ProcessRevision(jtaInformation, jProgressBar, cbFiles, revision, repositoryPath, status);

        Thread process = new Thread(processRevision);
        process.run();

//        cbFiles.setVisible(true);
//        btnUnderstand.setVisible(true);

    }//GEN-LAST:event_jTableContMouseClicked

    private void btnUnderstandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnderstandActionPerformed
        // TODO add your handling code here:

        if (initProject != null) {
            repositoryPath = initProject.getRepositoryPath();
        }
        Understanding understanding = new Understanding(jProgressBar, cbFiles, repositoryPath);
        Thread understand = new Thread(understanding);
        understand.start();
    }//GEN-LAST:event_btnUnderstandActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:

        JFileChooser chooser = new JFileChooser();
        int result = chooser.showSaveDialog(jMenu1);

        TableModel model = jTableCont.getModel();
        int columnCount = model.getColumnCount();
        int rowCount = model.getRowCount();

        if (result == chooser.APPROVE_OPTION) {
            Writer writer = KrakenFile.createWriter(chooser.getSelectedFile().getAbsolutePath());
            for (int i = 0; i < rowCount; i++) {
                if (model.getValueAt(i, 2) != null) {
                    KrakenFile.write(model.getValueAt(i, 0) + ", " + model.getValueAt(i, 1)
                            + ", " + model.getValueAt(i, 2) + ", " + model.getValueAt(i, 3) + "\n", writer);
                } else {
                    KrakenFile.write(model.getValueAt(i, 0) + ", " + model.getValueAt(i, 1)
                            + ", " + ", " + "\n", writer);
                }
            }

            if (initProject != null) {
                KrakenFile.write(initProject.getRepositoryPath(), writer);
            }

            KrakenFile.closeWriter(writer);
        }

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(jMenu1);

        if (result == JFileChooser.APPROVE_OPTION) {
            List<String> fileToLines = MergeUtils.fileToLines(chooser.getSelectedFile().getAbsolutePath());

            DefaultTableModel model = (DefaultTableModel) jTableCont.getModel();

            model.addColumn("SHA");
            model.addColumn("Status");
            model.addColumn("Files");
            model.addColumn("Percentage");

            int progress = 0;
            for (String line : fileToLines) {

                String[] split = line.split(",");

                if (split.length < 2) {
                    continue;
                }
                String sha = split[0];
                String status = split[1].replaceFirst(" ", "");
                String files = split[2].replaceFirst(" ", "");
                String percentage = split[3].replaceFirst(" ", "");

                model.insertRow(progress++, new Object[]{sha, status, files, percentage});

            }
            repositoryPath = fileToLines.get(fileToLines.size() - 1);

            jPanelContent.setVisible(true);
            jScrollPane1.setVisible(true);
            jTableCont.setVisible(true);

        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void btnNextConflictActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextConflictActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTableCont.getSelectedRow();

        for (int i = selectedRow + 1; i < jTableCont.getRowCount(); i++) {
            if (jTableCont.getModel().getValueAt(i, 1).toString().equals(Variables.CONFLICT)) {
                jTableCont.setEditingRow(i);
                System.out.println(i);
                break;
            }
        }
    }//GEN-LAST:event_btnNextConflictActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        if (initProject != null) {
            repositoryPath = initProject.getRepositoryPath();
        }

        List<String> allRevisions = GitCMD.getAllRevisions(repositoryPath);
        String date = GitCMD.getDate(repositoryPath, allRevisions.get(0));
        String date1 = GitCMD.getDate(repositoryPath, allRevisions.get(allRevisions.size() - 1));
        List<String> mergeRevisions = GitCMD.getMergeRevisions(repositoryPath);

        TableModel model = jTableCont.getModel();
        int rowCount = model.getRowCount();
        int conflicts = 0;

        for (int i = 0; i < rowCount; i++) {
            if (model.getValueAt(i, 1).equals(Variables.CONFLICT)) {
                conflicts++;
            }
        }

        String information = "Created: " + date1 + "\n"
                + "Updated: " + date + "\n"
                + "Commits: " + allRevisions.size() + "\n"
                + "Contributers: ? \n"
                + "Merges: " + mergeRevisions.size() + "\n"
                + "Conflicts: " + conflicts;

        JOptionPane.showMessageDialog(jPanelContent, information);

    }//GEN-LAST:event_jMenuItem4ActionPerformed

    String currentFile = "";

    private void cbFilesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbFilesItemStateChanged
        // TODO add your handling code here:

        if (cbFiles.getSelectedItem() != null && !currentFile.equals(cbFiles.getSelectedItem().toString())) {

            conflicts = new ArrayList<>();
            ConflictingChunk conflictingChunk = null;

            System.out.println(cbFiles.getSelectedItem().toString());
            currentFile = cbFiles.getSelectedItem().toString();

            if (initProject != null) {
                repositoryPath = initProject.getRepositoryPath();
            }

            String currentFile = cbFiles.getSelectedItem().toString();
            List<String> file = MergeUtils.fileToLines(currentFile);

            int lineNumber = 0;

            int id = 1;

            for (String line : file) {
                if (line.contains("<<<<<<<")) {
                    conflictingChunk = new ConflictingChunk();
                    conflictingChunk.setBegin(lineNumber);
                } else if (line.contains(">>>>>>>")) {
                    conflictingChunk.setEnd(lineNumber + 1);//Why?
                    conflictingChunk.setId("Case " + id++);

                    conflicts.add(conflictingChunk);
                }
                lineNumber++;
            }
            jCbxConflicts.removeAllItems();

            for (ConflictingChunk conflict : conflicts) {
                jCbxConflicts.addItem(conflict.getId());
            }
        }

        //TODO: 1) Identify the conflicting areas 
        //      2) Calc diffs
        //      3) Show Original version, diffs and final revision
    }//GEN-LAST:event_cbFilesItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //Dealing with AST

        int selectedIndex = jCbxConflicts.getSelectedIndex();
        int context = 3;
        ConflictingChunk conflictArea = conflicts.get(selectedIndex);

        if (initProject != null) {
            repositoryPath = initProject.getRepositoryPath();
        }

        //Creating repositories if they don't exist
        String relativePath = cbFiles.getSelectedItem().toString().replace(repositoryPath, "");
        String repositorySolutionPath = repositoryPath + "clone" + File.pathSeparator + "OK";
        String head1Repository = repositoryPath + "clone" + File.separator + "1";
        String head2Repository = repositoryPath + "clone" + File.separator + "2";

        if (!new File(repositorySolutionPath).isDirectory()) {
            System.out.println("Cloning Merge");
            GitCMD.clone(repositoryPath, repositoryPath, repositorySolutionPath);
        }

        if (!new File(head1Repository).isDirectory()) {
            System.out.println("Cloning 1");
            GitCMD.clone(repositoryPath, repositoryPath, head1Repository);
        }
        if (!new File(head2Repository).isDirectory()) {
            System.out.println("Cloning 2");
            GitCMD.clone(repositoryPath, repositoryPath, head2Repository);
        }

        //Checking out revisions
        GitCMD.checkout(repositorySolutionPath, Information.DEVELOPER_MERGE_REVISION);
        GitCMD.checkout(head1Repository, Information.HEAD1_REVISION);
        GitCMD.checkout(head2Repository, Information.HEAD2_REVISION);

        //Dealing with files that show the conflict scenario and the solution
        //Goal: obtain areas of the files to show
        List<String> fileConflict = MergeUtils.fileToLines(cbFiles.getSelectedItem().toString());
        List<String> fileSolution = MergeUtils.fileToLines(repositorySolutionPath + relativePath);

        int conflictLowerBound, conflictingUpperBound;
        conflictLowerBound = conflictArea.getBegin() - context;
        conflictingUpperBound = conflictArea.getEnd() + context;

        if (conflictLowerBound < 0) {
            conflictLowerBound = 0;
        }

        if (conflictingUpperBound > fileConflict.size()) {
            conflictingUpperBound = fileConflict.size();
        }

        List<String> conflictingArea = fileConflict.subList(conflictLowerBound, conflictingUpperBound);

        //Getting patterns
        List<String> patternBegin = fileConflict.subList(conflictLowerBound, conflictArea.getBegin());

        List<String> patternEnd;
        if (conflictArea.getEnd() <= conflictingUpperBound) {
            patternEnd = fileConflict.subList(conflictArea.getEnd(), conflictingUpperBound);
        } else {
            patternEnd = null;
        }

        List<String> solvingArea = ContextFinder.getSolution(patternBegin, patternEnd, fileSolution);
        //End dealing with files that show the conflict scenario and the solution

        //  AST begin
        try {

            int beginArea = conflictArea.getBegin() + 1;
            if (beginArea >= fileConflict.size()) {
                beginArea = fileConflict.size() - 1;
            }

            int endArea = conflictArea.getEnd() - 1;
            if (endArea < 0) {
                endArea = 0;
            }

            List<String> area = fileConflict.subList(beginArea, endArea);

            int division = 0;

            for (int i = 0; i < area.size(); i++) {
                String line = area.get(i);

                if (line.contains("=======")) {
                    division = i;
                }
            }

            List<String> conflictLeft = area.subList(0, division);
            String leftFile = head1Repository + relativePath;
            List<String> leftFileList = MergeUtils.fileToLines(leftFile);
            List<Integer> beginList = ContextFinder.getBegin(conflictLeft, leftFileList);
            
            int begin = 0;
            if(beginList.size() == 1)
                begin = beginList.get(0) + 1;//transforme in the real line (begining from 1)
            
            int end = begin + conflictLeft.size() - 1;

            ASTExtractor astLeft = new ASTExtractor(leftFile);
            astLeft.parser();
            List<String> kindConflict = astLeft.getStructures(begin, end);
            astLeft.print(kindConflict);
                    
            
            
            List<String> conflictRight = area.subList(division + 1, area.size());
            String rightFile = head2Repository + relativePath;
            List<String> rightFileList = MergeUtils.fileToLines(rightFile);

            

            ASTExtractor astRight = new ASTExtractor(rightFile);
            astRight.parser();

        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        //  AST end

        ShowCase showCase = new ShowCase(conflictingArea, solvingArea, "", "");
        showCase.setVisible(true);

    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNextConflict;
    private javax.swing.JButton btnUnderstand;
    private javax.swing.JComboBox cbFiles;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jCbxConflicts;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanelContent;
    private javax.swing.JPanel jPanelProgress;
    private javax.swing.JProgressBar jProgressBar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableCont;
    private javax.swing.JTextArea jtaInformation;
    // End of variables declaration//GEN-END:variables

}
