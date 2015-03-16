/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examencodtwitter;

/**
 *
 * @author dcuerdogarcia
 */
public class ExamenCodTwitter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int op;
        Metodos obx = new Metodos();
      
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog("opciones: \n1 --> TimeLine\n2 --> Buscar\n3 -->  Exit"));
            switch (op) {
                case 1:
                    obx.timeLine();
                    break;
                case 2:
                    obx.buscar();
                    break;
                //case 3:
                    //obx.publicar;
                   // break;
                case 3:
                    System.exit(0);
                default:
                    System.exit(0);
            }
        } while (op != 0 && op != 4);
    }
}

        
            
        
    
    
    

