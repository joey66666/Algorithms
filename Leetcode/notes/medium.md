
# Medium


##### [179] Largest Number
- Overide the Comparator to self-compare in dict order
- e.g.: 
    - if s1="76", s2="53", str1 = s1 + s2="7653", str2 = s2 + s1="5375"
    - in which case str2 < str1
    - call Arrays.Sort() with new comparator
    - mind the corner case with all zero


##### [495] Teemo Attacking
- Compare last time + duration and current time
- Time: O(n), Runtime: 99.3%   


##### [1094] Car Pooling
- Use one-hot int array to record numbers at every location on and off the bus
- Compute all the locations and compare with capacity
- Two circle
- Time: O(n), Runtime: 100%
