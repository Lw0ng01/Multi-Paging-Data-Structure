package Part2;

import java.util.HashMap;
import java.util.HashSet;

public class LeastFrequentlyUsed implements IPageReplacementStrategy {
    @Override
    /**
     * Returns page faults count using LRU page replacement algorithm
     * 
     * @param numOfFramesInPhysicalMemory: the physical memory capacity expressed in
     *                                     number of frames. Initially, all
     *                                     numOfFramesInPhysicalMemory are free
     * @param pages:                       the pages references that need to be
     *                                     allocated to the available frames
     */
    public int GetPageFaultsCount(int numOfFramesInPhysicalMemory, int[] pages) {
        // TODO implement Least Frequently Used (LRU) page replacement algorithm
        HashMap<Integer, Integer> index = new HashMap<Integer,Integer>();
        HashSet<Integer> pageSet = new HashSet<Integer>(numOfFramesInPhysicalMemory);
        int pageFaults = 0;

        for (int i = 0; i < pages.length; i++)
        {
            if (pageSet.size()< numOfFramesInPhysicalMemory)
            {
                if (!pageSet.contains(pages[i]))
                {
                    pageSet.add(pages[i]);
                    pageFaults++;
                }

                index.put(pages[i],i);
            }

            else
            {
                if (!pageSet.contains(pages[i]))
                {
                    int lfu = Integer.MAX_VALUE;
                    int lfu_val = Integer.MIN_VALUE;
                    for(HashMap.Entry<Integer, Integer> set: index.entrySet())
                    {
                        if(set.getValue() < lfu)
                        {
                            lfu = set.getValue();
                            lfu_val = set.getKey();
                        }
                    }

                    pageSet.remove(lfu_val);
                    index.remove(lfu_val);
                    pageSet.add(pages[i]);
                    pageFaults++;

                }

                index.put(pages[i],i);
            }
        }

        return pageFaults;
    }
}

