package disjointset;
public class DisjointSet {
    public static void main(String[] args) 
    {
       DisjointSet2 ds2=new DisjointSet2(5);
       ds2.makeset(1);
       ds2.makeset(2);
       ds2.makeset(3);
       ds2.makeset(4);
       ds2.makeset(5);
       ds2.mergeSet(1, 2);
       ds2.mergeSet(3, 4);
       ds2.mergeSet(4, 5);
       ds2.mergeSet(1, 5);
       ds2.print();
    }
    
}
class DisjointSet2
{
     int parent[];
    DisjointSet2(int n)
    {
        parent=new int[n+10];
    }
    public void makeset(int i)
    {
        for(int j=1;j<(parent.length)+1;j++)
        {
            parent[j]=-1;
        }
    }
    public int findSet(int i)
    {
        if(parent[i]==i)
               return i;
        else
            return findSet(parent[i]);
    }
    public void mergeSet(int i,int j)
    {
         if(findSet(i)==findSet(j)&&findSet(j)!=-1)
        {
            return;
        }
         if(parent[i]<parent[j])
         {
             parent[i]=j;
             parent[j]+=parent[i];
         }
         else
         {
             parent[j]=i;
             parent[i]+=parent[j];
         }
    }
    public void print()
    {
        for(int i=0;i<parent.length;i++)
             System.out.println(parent[i]);
    }
}