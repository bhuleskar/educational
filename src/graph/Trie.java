/*-
 * This computer program is the confidential information and proprietary trade
 * secret of Cisco Systems, Inc. Possessions and use of this program must
 * conform strictly to the license agreement between the user and Cisco Systems,
 * Inc., and receipt or possession does not convey any rights to divulge,
 * reproduce, or allow others to use this program without specific written
 * authorization of Cisco Systems, Inc.
 * 
 * Copyright 2011-2013 Cisco Systems, Inc. All rights reserved.
 * 
 * Created on Oct 13, 2013
 */
package graph;

import java.util.ArrayList;
import java.util.List;

public class Trie
{
   private TrieNode root;
   
   /**
    * Constructor
    */
   public Trie()
   {
      root = new TrieNode();
   }
   
   /**
    * Adds a word to the Trie
    * @param word
    */
   public void addWord(String word)
   {
      root.addWord(word.toLowerCase());
   }
   
   /**
    * Get the words in the Trie with the given
    * prefix
    * @param prefix
    * @return a List containing String objects containing the words in
    *         the Trie with the given prefix.
    */
   public List getWords(String prefix)
   {
      //Find the node which represents the last letter of the prefix
      TrieNode lastNode = root;
      for (int i=0; i<prefix.length(); i++)
      {
      lastNode = lastNode.getNode(prefix.charAt(i));
      
      //If no node matches, then no words exist, return empty list
      if (lastNode == null) return new ArrayList();      
      }
      
      //Return the words which eminate from the last node
      return lastNode.getWords();
   }
}
