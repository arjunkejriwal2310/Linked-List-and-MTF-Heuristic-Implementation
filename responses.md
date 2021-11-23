Responses for COSC-211 Assignment 2  
---
#### Name: Arjun Kejriwal

#### Question 1 
As seen in the table and graph in the attached MS Excel file,
the LinkedSimpleUSet implementation took a much greater amount 
of time (in milliseconds) than the MTFSimpleUSet implementation 
to find every distinct 5000 words from the text file and to 
add it to the set. Therefore, the MTFSimpleUSet implementation
is much faster and more efficient that the LinkedSimpleUSet 
implementation at computing the number of distinct words in a 
text file (in this case, "Moby Dick"). The move-to-front
heuristic does indeed lead to significant improvement in running 
time compared to an ordinary linked list. 

#### Question 2
I believe that if a text contains a lot of distinct words (fewer 
repeated words), the move-to-front heuristic would give a 
significant performance increase. This is mainly because, even
though the time taken to find for duplicates is similar in both
implementations, the move-to-front heuristic adds the new word
to the front of the list instead of the back, thus making it 
much more efficient. I also believe that the bigger the text file,
the greater the effect of using the move-to-front heuristic, given 
how the time taken by the LinkedSimpleUSet implementation 
increases exponentially as the number of words in the set increases.
Yes, I would expect most English language texts and books to have a 
diverse set of vocabulary and have a lot of words in them.

#### Question 3
I believe that the move-to-front heuristic would not give any 
significant performance improvement if the text file has a 
higher number of repetitions than the actual number of distinct 
words. Even though the move-to-front heuristic is faster at adding
a distinct word to a set, it spends some extra time as compared to
the LinkedSimpleUSet implementation when a duplicate word is found 
in the text (the move-to-front heuristic brings this word to the
front of the set, while the LinkedSimpleUSet implementation doesn't 
change the order of the set). MTFSimpleUSet will be much less efficient
than LinkedSimpleUSet when the text file contains way more repetitions
compared to distinct words, causing the drawback of MTFSimpleUSet to 
overshadow the key benefit of the implementation relative to the
LinkedSimpleUSet implementation. 