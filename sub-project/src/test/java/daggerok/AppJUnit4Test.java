package daggerok;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class AppJUnit4Test {

  ByteArrayOutputStream myOut;

  @Before
  public void setUp() throws Exception {
    myOut = new ByteArrayOutputStream();
    System.setOut(new PrintStream(myOut));
  }

  @Test
  public void testTrololo() throws UnsupportedEncodingException {
    App.main(new String[] {});
    final String stdOut = myOut.toString();
    assertThat(stdOut, containsString("yo!"));
  }
}
