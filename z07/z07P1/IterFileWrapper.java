package z07P1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class IterFileWrapper implements Iterable<String> {

    private BufferedReader reader;
    String name;


    public IterFileWrapper(String name) {
        this.name = name;
        try { reader = new BufferedReader(new FileReader(name)); }
        catch (Exception e) {}
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>(){
            private String line = "Coś";

            public boolean hasNext() {
                try {
                    line = reader.readLine();
                    if (line != null) {
                        return true;
                    }
                    else {
                        reader.close();
                        return false;
                    }
                }
                catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            public String next() {
                return line;
            }
        };

    }


}
