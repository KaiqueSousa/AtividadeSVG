/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 *
 * @author Kaique Sousa
 */
public class ArquivoSvg {
    
    private File arquivo;
    
    public ArquivoSvg(String geo1, String geo2) throws IOException, ParseException{
        
       arquivo = new File("arquivo.svg");
        
       WKTReader reader = new WKTReader();
        
       Geometry geom1 = reader.read(geo1);
       Geometry geom2 = reader.read(geo2); 
       
       String bx = new ViewBox().getViewBox(geom1, geom2);
  
       String path1 = SvgFactory.getSvg(geom1);
       String path2 = SvgFactory.getSvg(geom2);
        
       String p1 =  "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                        "\n" +
                        "<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">\n" +
                        "\n" +
                        "<svg xmlns=\"http://www.w3.org/2000/svg\"\n" +
                        "	xmlns:xlink=\"http://www.w3.org/1999/xlink\" width=\"400\" height=\"400\" viewBox=\"";
       
       String p2 =  "\">\n" +
                        "\n" +
                        "	<path d=\"";
       
       String p3 =  "\" stroke=\"blue\" stroke-width=\"0.01\" fill=\"blue\" fill-opacity=\"0.5\"/>\n" +
                        "	\n" +
                        "	<path d=\"";
       
       String p4 =  "\" stroke=\"red\" stroke-width=\"0.01\" fill=\"red\" fill-opacity=\"0.5\"/>\n" +
                        "\n" +
                        "</svg>";
       
       FileWriter fw = new FileWriter(arquivo, false);
       
       fw.write(p1);
       fw.write(bx);
       fw.write(p2);
       fw.write(path1);
       fw.write(p3);
       fw.write(path2);
       fw.write(p4);
       
       fw.close();
       
    }
    
}
