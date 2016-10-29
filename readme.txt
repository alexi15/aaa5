/******************************************************************************
*  Name:  Arnar Jóhannsson
*  LoginID: arnarjoh15
*  Group#: 9
*
 
*  Partner Name: Alex Kári Ívarsson      
*  Partner Login ID: alexi15
*  Partner Group#:  9  
 
 
*  Hours to complete assignment (optional):*
 ******************************************************************************/
6hrs


/******************************************************************************
 *  List in table format which input files you used to test your program.
 *  Fill in columns for how long your program takes to compress and
 *  decompress these instances (by applying BurrowsWheeler, MoveToFront,
 *  and Huffman in succession). Also, fill in the third column for
 *  the compression ratio (number of bytes in compressed message 
 *  divided by the number of bytes in the message).
 *****************************************************************************/

File       Encoding Time     Decoding time      Compression ratio
----------------------------------------------------------------
abra.txt	0,031 s		0,022 s			1,83
alphanum.txt	0,035 s		0,055 s			2,13
amendments	1,45 s		1,507 s			0,88

/******************************************************************************
 *  Compare the results of your program (compression ratio and running
 *  time) on mobydick.txt to that of the most popular Windows
 *  compression program (pkzip) or the most popular Unix/Mac one (gzip).
 *  If you don't have pkzip, use 7zip and compress using zip format.
 *****************************************************************************/


/******************************************************************************
 *  Give the order of growth of the running time of each of the 6
 *  methods as a function of the input size N and the alphabet size R
 *  both in practice (on typical English text inputs) and in theory
 *  (in the worst case), e.g., N, N + R, N log N, N^2, or R N.
 *
 *  Include the time for sorting circular suffixes in the
 *  Burrows-Wheeler encoder.
 *****************************************************************************/

                                      typical            worst
---------------------------------------------------------------------
BurrowsWheeler transform()
BurrowsWheeler inverseTransform()
MoveToFront encode()		      N * R		 N * R
MoveToFront decode()		      N * R		 N * R
Huffman compress()                    N + R log R        N + R log R
Huffman expand()                      N                  N





/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/
None.


/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 *****************************************************************************/
No help.

/******************************************************************************
 *  Describe any serious problems you encountered.                    
 *****************************************************************************/
None.


/******************************************************************************
 *  If you worked with a partner, assert below that you followed
 *  the protocol as described on the assignment page. Give one
 *  sentence explaining what each of you contributed.
 *****************************************************************************/
Arnar vann í MoveToFront og skýrslunni. Alex í BurrowsWheeler, CircularSuffixArray og skýrslunni. 


/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 *****************************************************************************/
Skemmtilegt verkefni.