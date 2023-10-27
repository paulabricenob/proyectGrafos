    /** 
    * Método que lee el archivo y agrega los usuarios a la lista de personas
    * @param fileRoute
    * @return lista de personas
    */
    public List read_users(String fileRoute){
        List persons = new List();
        
        String line;
        String str = "";
        
        File newFile = new File(fileRoute);
        try {
            if (newFile.exists() == false) {
                newFile.createNewFile();
            } else {
                FileReader fr = new FileReader(newFile);
                BufferedReader br = new BufferedReader(fr);

                while (!"Relaciones".equals(line = br.readLine())) {
                    if (line.isEmpty() == false && line.equals("Usuarios") == false) {
                        str += line + "\n";
                    }
                }
                if ("".equals(str) == false) {
                    String[] str_split = str.split("\n");
                    for (int x = 0; x < str_split.length; x++) {
                        String[] Str = str_split[x].split(", ");
                        Vperson person = new Vperson(Integer.parseInt(Str[0]), Str[1]);
                        persons.append(person);
                    }
                }
                br.close();

            }
        } catch (Exception e) {
            
        }
        return persons;
        
        
    }
    
    /** 
    * Método que lee y agrega las relaciones a la lista de relaciones
    * @param allPerson 
    * @param fileRoute
    * @return lista de relaciones
    */
    public List read_relations(List allPerson, String fileRoute) {
        List relations = new List();
        String line;
        String str = "";
        
        File newFile = new File(fileRoute);
        try {
            if (newFile.exists() == false) {
                newFile.createNewFile();
            } else {
                FileReader fr = new FileReader(newFile);
                BufferedReader br = new BufferedReader(fr);

                boolean run = false;
                while (null != (line = br.readLine())) {
                    if (line.isEmpty() == false && line.equals("Usuarios") == false && run == true) {
                        str += line + "\n";
                    }
                    if (line.equals("Relaciones") == true) {
                        run = true;
                    }

                }

                if ("".equals(str) == false) {
                    String[] str_split = str.split("\n");
                    for (int x = 0; x < str_split.length; x++) {
                        String[] Str = str_split[x].split(", ");
                        Edge newEdge = new Edge(Integer.parseInt(Str[0]), Integer.parseInt(Str[1]), Integer.parseInt(Str[2]));
                        newEdge.setRead(true);
                        relations.append(newEdge);
                    }
                }
                br.close();

            }
        } 
        catch (Exception e) {
            
        }
        return relations;
    }
