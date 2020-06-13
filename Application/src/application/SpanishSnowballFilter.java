/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;
import java.io.IOException;
import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.tartarus.snowball.ext.SpanishStemmer;

/**
 * @author SumeetS
 *
 */
public class SpanishSnowballFilter extends TokenFilter {
private final CharTermAttribute termAttr = addAttribute(CharTermAttribute.class);
/**
  * @param input
  */
 public SpanishSnowballFilter(TokenStream input) {
   super(input);
 }

 @Override
 public boolean incrementToken() throws IOException {
   if (input.incrementToken()) {
   String parsed = null;
        try {
     SpanishStemmer stemmer = new SpanishStemmer();
     parsed = termAttr.toString();
     stemmer.setCurrent(parsed);
     if (stemmer.stem()){
      parsed = stemmer.getCurrent();
     }
        } catch (Exception e) {
          e.printStackTrace();
        }
char[] parsedArray = parsed.toCharArray();
termAttr.setEmpty();
        termAttr.copyBuffer(parsedArray, 0, parsedArray.length);
return true;
   } else
   return false;
 }
}