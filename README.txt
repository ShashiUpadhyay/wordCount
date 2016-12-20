CS542 Design Patterns
Fall 2016
ASSIGNMENT-4 README FILE

Due Date: <Wednesday, November 23, 2016>
Submission Date: <Thursday, October 24, 2016>
Grace Period Used This Project: 1 Day
Grace Period Remaining: 1 Day
Author: Shashi Upadhyay
e-mail: supadhy2@binghamton.edu

PURPOSE:

[
Apply the Observer, Visitor and Clone design principles and verify the impact on performance based on data structure. 
]

PERCENT COMPLETE:

[
100%
]


PARTS THAT ARE NOT COMPLETE:

[
None
]


BUGS:

[
All the corner cases uploaded on the blackboard are verified and code is validated for those cases.
]

FILES:

[
Below listed files are included with the attachment:
Total files : 20

upadhyay_shashi/wordCount/src/wordCount/dao/Observer.java
upadhyay_shashi/wordCount/src/wordCount/dao/Subject.java
upadhyay_shashi/wordCount/src/wordCount/dao/Node.java
upadhyay_shashi/wordCount/src/wordCount/dao/TreeInterface.java
upadhyay_shashi/wordCount/src/wordCount/dao/BST.java
upadhyay_shashi/wordCount/src/wordCount/dao/Word.java
upadhyay_shashi/wordCount/src/wordCount/driver/Driver.java
upadhyay_shashi/wordCount/src/wordCount/util/Operation.java
upadhyay_shashi/wordCount/src/wordCount/util/Logger.java
upadhyay_shashi/wordCount/src/wordCount/util/InputValidations.java
upadhyay_shashi/wordCount/src/wordCount/util/FileProcessor.java
upadhyay_shashi/wordCount/src/wordCount/util/PerformanceValidation.java
upadhyay_shashi/wordCount/src/wordCount/util/Result.java
upadhyay_shashi/wordCount/src/wordCount/visitors/Visitor.java
upadhyay_shashi/wordCount/src/wordCount/visitors/CloneAndObserverVisitor.java
upadhyay_shashi/wordCount/src/wordCount/visitors/PopulateVisitor.java
upadhyay_shashi/wordCount/src/wordCount/visitors/WordCountVisitor.java
upadhyay_shashi/wordCount/build.xml
upadhyay_shashi/wordCount/README.txt
upadhyay_shashi/wordCount/input_clone_verification.txt
				 			
]

VERIFICATION OF CLONING:

[

In order to verify the working of clining, I have tried to updating the contents of the root node & left and right child of the root node.
 And post update I am trying to print the contents of Original as well as backup copy.
 
Input to be cloned will be picked from input file 
upadhyay_shashi/wordCount/clone_verification_input.txt

And its output will be generated to three file
1) upadhyay_shashi/wordCount/output_clone_verification_original_tree_before_update.txt
Here BST of original before update will be printed in IN-Order format

2) upadhyay_shashi/wordCount/output_clone_verification_original_post_update.txt
Here BST of original after update will be printed in IN-Order format

3) upadhyay_shashi/wordCount/output_clone_verification_backup.txt	
Here BST of backup copy will be printed in IN-Order format
 
There is no need to provide the input and output files which are required for the verification of Cloning; through command prompt.

Program will itself pick these files. 
 
 
]
 
CHOICE OF DATA STRUCTURE:

[
Data structre to hold contents:
Binary Search Tree: Insertion and Search Complexity of Binary Search Tree is O(Log(n) 
]

TO UNTAR:

[
Untar the files using the below mentioned command. 
Command to untar : tar -xvzf  upadhyay_shashi_assign4.tar.gz
]

TO COMPILE:

[

Go to upadhyay_shashi folder using below command
Command :  cd upadhyay_shashi/wordCount/

Please compile as : ant compile_all

]

TO RUN:

[
Go to upadhyay_shashi folder using below command
Command :  cd upadhyay_shashi/wordCount/
And then run below mentioned command

Please run as     : ant -Darg0=input1.txt -Darg1=output.txt -Darg2=200 run

If already inside upadhyay_shashi/wordCount/ then directly command : 
ant -Darg0=input1.txt -Darg1=output.txt -Darg2=200  run
]

SAMPLE CONSOLE OUTPUT:

[
	 [java] Logger Message -> Total Execution Time	:	11 milliseconds
     
]

SAMPLE OUTPUT OF OUTPUT.TXT:

[
	 Total words		:	10123
	 Distinct Words		:	3505
	 Characters			:	44722
     
]

SAMPLE OUTPUT OF output_clone_verification_original_tree_before_update.txt:


[


Printing Original Tree Before Update
[Word: with	Word Count: 1	Character Count: 4]
[Word: was	Word Count: 1	Character Count: 3]
[Word: to	Word Count: 2	Character Count: 4]
[Word: this	Word Count: 1	Character Count: 4]
[Word: they	Word Count: 1	Character Count: 4]
[Word: thenceforward	Word Count: 1	Character Count: 13]
[Word: then	Word Count: 1	Character Count: 4]
[Word: received	Word Count: 1	Character Count: 8]
[Word: prosperity	Word Count: 1	Character Count: 10]
[Word: proliferent	Word Count: 1	Character Count: 11]
[Word: nothing	Word Count: 1	Character Count: 7]
[Word: not	Word Count: 1	Character Count: 3]
[Word: mothers	Word Count: 1	Character Count: 7]
[Word: molestful	Word Count: 1	Character Count: 9]
[Word: her	Word Count: 1	Character Count: 3]
[Word: had	Word Count: 1	Character Count: 3]
[Word: for	Word Count: 1	Character Count: 3]
[Word: felt	Word Count: 1	Character Count: 4]
[Word: except	Word Count: 1	Character Count: 6]
[Word: citizens	Word Count: 1	Character Count: 8]
[Word: chiefly	Word Count: 1	Character Count: 7]
[Word: can	Word Count: 1	Character Count: 3]
[Word: be	Word Count: 2	Character Count: 4]
[Word: at	Word Count: 1	Character Count: 2]
[Word: as	Word Count: 1	Character Count: 2]
[Word: anyway	Word Count: 1	Character Count: 6]
[Word: and	Word Count: 2	Character Count: 6]
[Word: already	Word Count: 1	Character Count: 7]
[Word: all	Word Count: 2	Character Count: 6]
[Word: able	Word Count: 1	Character Count: 4]
[Word: To	Word Count: 1	Character Count: 2]

]

SAMPLE OUTPUT OF output_clone_verification_original_post_update.txt:

[
	
 Root Node -> Prior Update [Word: To	Word Count: 1	Character Count: 2]

 Root Node -> Post Update [Word: To	Word Count: 1000	Character Count: 2000]

 Root Node -> Left Child : Prior update [Word: her	Word Count: 1	Character Count: 3]

 Root Node -> Left Child : Post update [Word: her	Word Count: 4000	Character Count: 12000]

Left Child post update [Word: her	Word Count: 4000	Character Count: 12000]


Printing Original Copy
[Word: with	Word Count: 1	Character Count: 4]
[Word: was	Word Count: 1	Character Count: 3]
[Word: to	Word Count: 2	Character Count: 4]
[Word: this	Word Count: 1	Character Count: 4]
[Word: they	Word Count: 1	Character Count: 4]
[Word: thenceforward	Word Count: 1	Character Count: 13]
[Word: then	Word Count: 1	Character Count: 4]
[Word: received	Word Count: 1	Character Count: 8]
[Word: prosperity	Word Count: 1	Character Count: 10]
[Word: proliferent	Word Count: 1	Character Count: 11]
[Word: nothing	Word Count: 1	Character Count: 7]
[Word: not	Word Count: 1	Character Count: 3]
[Word: mothers	Word Count: 1	Character Count: 7]
[Word: molestful	Word Count: 1	Character Count: 9]
[Word: her	Word Count: 4000	Character Count: 12000]
[Word: had	Word Count: 1	Character Count: 3]
[Word: for	Word Count: 1	Character Count: 3]
[Word: felt	Word Count: 1	Character Count: 4]
[Word: except	Word Count: 1	Character Count: 6]
[Word: citizens	Word Count: 1	Character Count: 8]
[Word: chiefly	Word Count: 1	Character Count: 7]
[Word: can	Word Count: 1	Character Count: 3]
[Word: be	Word Count: 2	Character Count: 4]
[Word: at	Word Count: 1	Character Count: 2]
[Word: as	Word Count: 1	Character Count: 2]
[Word: anyway	Word Count: 1	Character Count: 6]
[Word: and	Word Count: 2	Character Count: 6]
[Word: already	Word Count: 1	Character Count: 7]
[Word: all	Word Count: 2	Character Count: 6]
[Word: able	Word Count: 1	Character Count: 4]
[Word: To	Word Count: 1000	Character Count: 2000]

     
]


SAMPLE OUTPUT OF output_clone_verification_backup.TXT:

[

 Root Node -> Prior Update [Word: To	Word Count: 1	Character Count: 2]

 Root Node -> Post Update [Word: To	Word Count: 1000	Character Count: 2000]

 Root Node -> Left Child : Prior update [Word: her	Word Count: 1	Character Count: 3]

 Root Node -> Left Child : Post update [Word: her	Word Count: 4000	Character Count: 12000]

Left Child post update [Word: her	Word Count: 4000	Character Count: 12000]


Printing Cloned Copy

[Word: with	Word Count: 1	Character Count: 4]
[Word: was	Word Count: 1	Character Count: 3]
[Word: to	Word Count: 2	Character Count: 4]
[Word: this	Word Count: 1	Character Count: 4]
[Word: they	Word Count: 1	Character Count: 4]
[Word: thenceforward	Word Count: 1	Character Count: 13]
[Word: then	Word Count: 1	Character Count: 4]
[Word: received	Word Count: 1	Character Count: 8]
[Word: prosperity	Word Count: 1	Character Count: 10]
[Word: proliferent	Word Count: 1	Character Count: 11]
[Word: nothing	Word Count: 1	Character Count: 7]
[Word: not	Word Count: 1	Character Count: 3]
[Word: mothers	Word Count: 1	Character Count: 7]
[Word: molestful	Word Count: 1	Character Count: 9]
[Word: her	Word Count: 4000	Character Count: 12000]
[Word: had	Word Count: 1	Character Count: 3]
[Word: for	Word Count: 1	Character Count: 3]
[Word: felt	Word Count: 1	Character Count: 4]
[Word: except	Word Count: 1	Character Count: 6]
[Word: citizens	Word Count: 1	Character Count: 8]
[Word: chiefly	Word Count: 1	Character Count: 7]
[Word: can	Word Count: 1	Character Count: 3]
[Word: be	Word Count: 2	Character Count: 4]
[Word: at	Word Count: 1	Character Count: 2]
[Word: as	Word Count: 1	Character Count: 2]
[Word: anyway	Word Count: 1	Character Count: 6]
[Word: and	Word Count: 2	Character Count: 6]
[Word: already	Word Count: 1	Character Count: 7]
[Word: all	Word Count: 2	Character Count: 6]
[Word: able	Word Count: 1	Character Count: 4]
[Word: To	Word Count: 1000	Character Count: 2000]


]

EXTRA CREDIT:

[
N/A
]


BIBLIOGRAPHY:

[
Below websites were referred for the code.
http://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/BTree.java.html
http://tutorials.jenkov.com/java/enums.html
http://bigocheatsheet.com/
]

ACKNOWLEDGEMENT:

[
During coding, websites mentioned in the Bibliography section were being referred.
]

