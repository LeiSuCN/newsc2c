import com.leisucn.xa.newsc2c.parser.bbc.Index;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;
import java.util.Map;

/**
 * Created by SL on 2017/4/7.
 */
public class BbcIndexTest {

    @Test
    public void test_index() throws Exception{
        Index bbcIndex = new Index();

        Map<String, List<Map<String, String>>> content =
                bbcIndex.parse();

        content.keySet().forEach( blockKey -> {
            System.out.println("==== ==== ==== ==== ==== ==== ==== ====");
            System.out.println(blockKey);

            content.get(blockKey).forEach( m -> {
                System.out.println("---- ---- ---- ----");
                System.out.println("title:");
                System.out.println(m.get("title"));
                System.out.println("summary:");
                System.out.println(m.get("summary"));
            });

        });
    }
}
