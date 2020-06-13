/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.Map;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.util.TokenFilterFactory;
/**
 * @author SumeetS
 *
 */
public class SpanishSnowballFilterFactory extends TokenFilterFactory {
/**
  * @param args
  */
  public SpanishSnowballFilterFactory(Map<String, String> args) {
   super(args);
   if (!args.isEmpty()) {
    throw new IllegalArgumentException("Unknown parameters: " + args);
   }
  }
/* (non-Javadoc)
  * @see org.apache.lucene.analysis.util.TokenFilterFactory#create(org.apache.lucene.analysis.TokenStream)
  */
  @Override
  public TokenStream create(TokenStream input) {
   return new SpanishSnowballFilter(input);
  }
}
