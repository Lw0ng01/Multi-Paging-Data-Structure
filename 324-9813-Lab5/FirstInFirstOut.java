package Part2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class FirstInFirstOut implements IPageReplacementStrategy {
    @Override
    /**
     * Returns page faults count using FIFO page replacement algorithm
     * 
     * @param numOfFramesInPhysicalMemory: the physical memory capacity expressed in
     *                                     number of frames. Initially, all
     *                                     numOfFramesInPhysicalMemory are free
     * @param pages:                       the pages references that need to be
     *                                     allocated to the available frames
     */
    public int GetPageFaultsCount(int numOfFramesInPhysicalMemory, int[] pages) {
        // TODO implement First In First Out (FIFO) page replacement algorithm
        int page_capacity = 0;
        HashSet<Integer> s = new HashSet<>(page_capacity);
        Queue<Integer> index = new LinkedList<>();

        int page_faults = 0;

        for (int i = 0; i < pages.length; i++)
        {
            if (s.size() < numOfFramesInPhysicalMemory)
            {
                if (!s.contains(pages[i]))
                {
                    s.add(pages[i]);
                    page_faults++;
                    index.add(pages[i]);
                }
            }
            else
            {
                if (!s.contains(pages[i]))
                {

                }
            }

        }




        return 0;
    }
}
