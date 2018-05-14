Mocks are typically used in the following scenarios :
1. In unit tests, for example, we mock a method, and if other methods are tuned, we return a mock directly. 
2. In the client testing process, such as the service end is not developed, we can mock such interfaces.
Also, there are some exception scenarios in the functional testing process that we can mock to make data.
3. No need to mock all dependent objects, mock only those that are complex and time-dependent.
4. If hierarchical automation is done, the high-level test design can be based on the following assumptions:
Low level testing has ensured the quality of the lower-level objects, and the high-level dependency on the lower level can mock,There is no need to care about the internal logical quality of the lower-level objects on which they depend.
