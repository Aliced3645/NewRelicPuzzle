NewRelicPuzzle
==============
Thread pool example:
http://stackoverflow.com/questions/2332537/producer-consumer-threads-using-a-queue

Simple Concurrent Server Implementation
1. For simplicity, i did not use singleton/Spring to manage objects, but either
   could be easily added if we want to.

2. Assumptions:
(1) The log file contains duplicate numbers because checking duplicates from the very beginning has an unbounded problem scope, and the data size we maintain could grow to pretty large one. So just counting for duplicates for every last 10 seconds could simplify the problem a bit.
(2) I assume using Java's thread pool implmentation is allowed, it could also make the work a bit easier.
    
