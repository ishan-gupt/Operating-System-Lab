#include<stdio.h>
void main()
{
	int bno, pno, i, j;
	printf("Enter no. of blocks: ");
	scanf("%d", &bno);
	int bsize[bno];
	printf("\nEnter size of each block: ");
	for(i = 0; i < bno; i++){
	scanf("%d", &bsize[i]);
	}
	printf("\nEnter no. of processes: ");
	scanf("%d", &pno);
	int psize[pno];
	printf("\nEnter size of each process: ");
	for(i = 0; i < pno; i++)
		scanf("%d", &psize[i]);
	int flags[bno],allocation[pno];
	for(i = 0; i < bno; i++)
	{
		 flags[i] = 0;
	}
	for(i=0;i<pno;i++){
	    allocation[i]=-1;
	}
    for (int i=0; i<pno; i++)
    {
        int bestIdx = -1;
        for (int j=0; j<bno; j++)
        {
            if (bsize[j] >= psize[i])
            {
                if (bestIdx == -1)
                    bestIdx = j;
                else if (bsize[bestIdx] > bsize[j])
                    bestIdx = j;
            }
        }
        if (bestIdx != -1)
        {
            allocation[i] = bestIdx;
        }
    }
    int diff=0;
	printf("\nBlock no.\tsize\t\tprocess no.\t\tsize");
	for(i = 0; i < bno; i++)
	{
		printf("\n%d\t\t%d\t\t", i+1, bsize[i]);
		if(flags[i] == 1){
			printf("%d\t\t\t%d",allocation[i]+1,psize[allocation[i]]);
			diff=diff+(bsize[i]-psize[allocation[i]]);
		}
		else
			printf("Not allocated");
	}
    printf("\nSize of memory wasted: ");
	printf("%d",diff);
}