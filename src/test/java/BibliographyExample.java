import com.emrage.latex.LatexDocument;
import com.emrage.latex.bib.Bibliography;
import com.emrage.latex.bib.BibliographyType;
import com.emrage.latex.text.Flush;
import com.emrage.latex.text.Paragraph;

import java.io.IOException;
import java.nio.file.Path;

public class BibliographyExample {

    public static void main(String[] args) throws IOException {
        var document = new LatexDocument();

        var bibliography = document.getLatexBibliography();
        bibliography.addBibliography(new Bibliography()
                .setBibliographyType(BibliographyType.ARTICLE)
                .setReference("test")
                .setAuthor("Test")
                .setTitle("Test title"));

        var paragraph = new Paragraph();
        paragraph.setFlush(Flush.LEFT);
        paragraph.addln("This is a paragraph " + bibliography.cite("test"));
        document.add(paragraph);

        document.save(Path.of("test"));
    }
}
