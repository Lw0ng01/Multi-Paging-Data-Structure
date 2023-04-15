package Part2;

import java.util.HashMap;
import java.util.HashSet;

public class MostFrequentlyUsed implements IPageReplacementStrategy {
    @Override
    /**
     * Returns page faults count using MFU page replacement algorithm
     * 
     * @param numOfFramesInPhysicalMemory: the physical memory capacity expressed in
     *                                     number of frames. Initially, all
     *                                     numOfFramesInPhysicalMemory are free
     * @param pages:                       the pages references that need to be
     *                                     allocated to the available frames
     */
    public int GetPageFaultsCount(int numOfFramesInPhysicalMemory, int[] pages) {
        // TODO implement Most Frequently Used (MFU) page replacement algorithm
        HashMap<Integer, Integer> index = new HashMap<Integer, Integer>();
        HashSet<Integer> pageSet = new HashSet<Integer>(numOfFramesInPhysicalMemory);
        int pageFaults = 0;

        for (int i = 0; i < pages.length; i++) {
            if (pageSet.size() < numOfFramesInPhysicalMemory) 
            {
                if (!pageSet.contains(pages[i])) {
                    pageSet.add(pages[i]);
                    pageFaults++;
                }

                index.put(pages[i], i);

            } 
            else 
            {
                if (!pageSet.contains(pages[i])) 
                {
                    int mfu = Integer.MAX_VALUE;
                    int mfu_val = Integer.MIN_VALUE;
                    for (HashMap.Entry<Integer, Integer> set : index.entrySet()) 
                    {
                        if (set.getValue() < mfu) 
                        {
                            mfu = set.getValue();
                            mfu_val = set.getKey();
                        }
                    }

                    pageSet.remove(mfu_val);
                    index.remove(mfu_val);
                    pageSet.add(pages[i]);
                    pageFaults++;
                }

                index.put(pages[i], i);
            }
        }

        return pageFaults;
    }
}
