    

    public void WriteTxt(List allPerson,String fileRoute) {
        if ("".equals(fileRoute)){
            JOptionPane.showMessageDialog(null, "Error! No hay ruta de acceso.");
        } 
        else{
            String str = "Usuarios\n";
            if (allPerson.isEmpty() == false){
                for (int x = 0; x < allPerson.len(); x++){
                    Vperson person = (Vperson) allPerson.get(x);
                    str = str + person.getVnum() + ", " + person.getName() + "\n";
                }
                str = str + "Relaciones\n";
                for (int x = 0; x < allPerson.len(); x++){
                    Vperson person = (Vperson) allPerson.get(x);
                    List auxList = person.getAdyList();
                    for (int y = 0; y < auxList.len(); y++){
                        Edge edge = (Edge) auxList.get(y);
                        if(edge.isRead()){
                            str += Integer.toString(edge.getStart()) + ", " + Integer.toString(edge.getEnd()) + ", " + Integer.toString(edge.getWeight()) + "\n";                                             
                        }
                    }
                }
            }
            try{
               PrintWriter pw = new PrintWriter(fileRoute); 
               pw.print(str);
               pw.close();
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Error! No se ha escrito sobre el archivo.");
            }
        }
    }


