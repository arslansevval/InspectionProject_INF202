
package export;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javax.imageio.ImageIO;
import org.apache.log4j.BasicConfigurator; 
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class ExportToPDF {
public void pdf(AnchorPane root) {
    //Button button = new Button("print");
    //StackPane root = new StackPane(button);
    //button.setOnAction(evt -> {
    BasicConfigurator.configure();
    root.getChildrenUnmodifiable();
        try {
            WritableImage nodeshot = root.snapshot(new SnapshotParameters(), null);
            System.err.println("P");
            // store image in-memory
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            ImageIO.write(SwingFXUtils.fromFXImage(nodeshot, null), "png", output);
            output.close();
            System.err.println("Pd");
            PDDocument doc = new PDDocument();
            PDPage page = new PDPage();
            PDImageXObject pdimage;
            PDPageContentStream content;
            System.err.println("nere");
            pdimage = PDImageXObject.createFromByteArray(doc, output.toByteArray(), "png");
            System.err.println("desin");
            content = new PDPageContentStream(doc, page);
            System.err.println("Pdf ");
            // fit image to media box of page
            PDRectangle box = page.getMediaBox();
            double factor = Math.min(box.getWidth() / nodeshot.getWidth(), box.getHeight() / nodeshot.getHeight());

            float height = (float) (nodeshot.getHeight() * factor);

            // beware of inverted y axis here
            content.drawImage(pdimage, 0, box.getHeight() - height, (float) (nodeshot.getWidth() * factor), height);

            content.close();
            doc.addPage(page);
            System.err.println("Pdf wri");
            File outputFile = new File("C:\\Users\\arsla\\Documents\\NetBeansProjects\\Projekt\\newProjekt\\Report.pdf");

            doc.save(outputFile);
            doc.close();
            System.err.println("Pdf written succesfullly");
            
        } catch (IOException e) {
        }
      
}

  
}
