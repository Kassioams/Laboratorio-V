
package comparadores;

        import java.io.StringReader;
        import java.text.ParseException;
        import java.text.SimpleDateFormat;
        import java.util.Comparator;
        import java.util.Date;


public class ComparadorData implements Comparator<String> {
    @Override
    public int compare(String s, String t1) {
        String[] lista = s.split(", ");
        String[] lista2 = t1.split(", ");
        String data = lista[0];
        String data2 = lista2[0];

        String listaResto1 = "";
        listaResto1 += lista[1];
        listaResto1 += lista[2];
        listaResto1 += lista[3];

        String listaResto2 = "";
        listaResto2 += lista[1];
        listaResto2 += lista[2];
        listaResto2 += lista[3];
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(data2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (data.compareTo(data2) == 0) {
            return listaResto1.compareTo(listaResto2);
        } else {
            return data.compareTo(data2);
        }
    }
}