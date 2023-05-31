/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package movie;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author PC PRAKTIKUM
 */
public class ControllerMovie {
    ModelMovie ModelMovie;
    ViewMovie ViewMovie;
    public String data;
    public ControllerMovie(ModelMovie ModelMovie, ViewMovie ViewMovie){
        this.ModelMovie = ModelMovie;
        this.ViewMovie = ViewMovie;

        if (ModelMovie.getBanyakData()!=0) {
            String dataMovie[][] = ModelMovie.readMovie();
            ViewMovie.tabel.setModel((new JTable(dataMovie, ViewMovie.namaKolom)).getModel());
        }else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }

        ViewMovie.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String Judul = ViewMovie.getJudul();
                double Alur = Double.parseDouble(ViewMovie.getAlur());
                double Penokohan = Double.parseDouble(ViewMovie.getPenokohan());
                double Akting = Double.parseDouble(ViewMovie.getAkting());
                double Nilai = (Alur+Penokohan+Akting)/3;
                ModelMovie.insertMovie(Judul, Alur, Penokohan, Akting, Nilai);

                String dataMovie[][] = ModelMovie.readMovie();
                ViewMovie.tabel.setModel((new JTable(dataMovie, ViewMovie.namaKolom)).getModel());
            }
        });

        ViewMovie.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                String Judul = ViewMovie.getJudul();
                double Alur = Double.parseDouble(ViewMovie.getAlur());
                double Penokohan = Double.parseDouble(ViewMovie.getPenokohan());
                double Akting = Double.parseDouble(ViewMovie.getAkting());
                double Nilai = (Alur+Penokohan+Akting)/3;
                ModelMovie.updateMovie(Judul, Alur, Penokohan, Akting, Nilai);

                String dataMovie[][] = ModelMovie.readMovie();
                ViewMovie.tabel.setModel((new JTable(dataMovie, ViewMovie.namaKolom)).getModel());
            }
        });

        ViewMovie.btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                ViewMovie.tfJudul.setText("");
                ViewMovie.tfAlur.setText("");
                ViewMovie.tfPenokohan.setText("");
                ViewMovie.tfAkting.setText("");
            }
        });


        ViewMovie.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);

                int baris = ViewMovie.tabel.getSelectedRow();
                data = ViewMovie.tabel.getValueAt(baris, 0).toString();
                String dataUpdate[] = new String[4];
                dataUpdate[0] = ViewMovie.tabel.getValueAt(baris, 0).toString();
                dataUpdate[1] = ViewMovie.tabel.getValueAt(baris, 1).toString();
                System.out.println(data);
            }
        });

        ViewMovie.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int input = JOptionPane.showConfirmDialog(null,
                        "Apa anda ingin menghapus " + data + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);

                if (input == 0) {
                    ModelMovie.deleteMovie(data);
                    String dataMovie[][] = ModelMovie.readMovie();
                    ViewMovie.tabel.setModel((new JTable(dataMovie, ViewMovie.namaKolom)).getModel());
                } else {
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
                }
            }
        });

    }
}

