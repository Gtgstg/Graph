package com.company.SteinerTree;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        public byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
public class Main {

    public static void main(String[] args) throws IOException {
        Reader r=new Reader();
        PrintWriter out=new PrintWriter(System.out);
        while(new Main().run(r,out));
        out.close();
        }
        int id_cnt=0;
    HashMap<String,Integer> mmp=new HashMap<>();
    int getID(String s){
        Integer rr=mmp.get(s);
        if(rr!=null) return rr;
        mmp.put(s,id_cnt);
        return id_cnt++;
    }
    int N,M,oo=987654321;
    int[][] cost;
    boolean run(Reader r,PrintWriter out) throws IOException {
        N=r.nextInt();
        M=r.nextInt();
        if(N==0 && M==0)
            return false;
        cost =new int[N][N];
        for(int[] cc:cost)
            Arrays.fill(cc,oo);
        for(int i=0;i<N;i++)
            cost[i][i]=0;
        for(int i=0;i<N;i++)
            getID(r.readLine());
        while(M-->0){
            String[] s=r.readLine().split(" ");
            int i=getID(s[0]);
            int j=getID(s[1]);
            int c=Integer.parseInt(s[2]);
            cost[i][j]=cost[j][i]=Math.min(cost[i][j],c);
        }
        for(int k=0;k<N;k++)
            for(int i=0;i<N;i++)
                for(int j=0;j<N;j++)
                    cost[i][j]=Math.min(cost[i][j],cost[i][k]+cost[k][j]);
        TreeSet<Integer> ts=new TreeSet<>();
        int[][] roads=new int[4][2];
        for(int i=0;i<4;i++){
            String[] s=r.readLine().split(" ");
            roads[i][0]=getID(s[0]);
            roads[i][1]=getID(s[1]);
            ts.add(roads[i][0]);
            ts.add(roads[i][1]);
        }
        int nTerm=ts.size();
        int[] group=new int[nTerm];
        int cnt=0;
        for(int v:ts)
            group[cnt++]=v;
        int[][] minCost =new int[N][1<<nTerm];
        for(int[] mm:minCost)
            Arrays.fill(mm,oo);
        for(int i=0;i<nTerm;i++)
            minCost[group[i]][1<<i]=0;
        for(int mask=0;mask<(1<<nTerm);mask++){
            for(int i=0;i<N;i++){
                for(int ss=mask;ss>0;ss=(ss-1)&mask)
                    minCost[i][mask]=Math.min(minCost[i][mask],minCost[i][ss]+minCost[i][mask-ss]);
                    if(minCost[i][mask]<oo){
                        for(int j=0;j<N;j++)
                            minCost[j][mask]=Math.min(minCost[j][mask],minCost[i][mask]+cost[i][j]);
                    }
            }
        }
        int[] minTotal=new int[1<<nTerm];
        Arrays.fill(minTotal,oo);
        for(int mask=0;mask<(1<<nTerm);mask++)
            for(int i=0;i<N;i++)
                minTotal[mask]=Math.min(minTotal[mask],minCost[i][mask]);
        int[] dp=new int[1<<4];
        Arrays.fill(dp,oo);
        dp[0]=0;
        for(int mask=0;mask<(1<<4);mask++){
            if(dp[mask]==oo)
                continue;
            for (int smask=0;smask<(1<<4);smask++){
                if((mask&smask)>0)
                    continue;
                int joinMask=0;
                for(int i=0;i<4;i++){
                    if(((1<<i)&smask)>0){
                        int x=Arrays.binarySearch(group,roads[i][0]);
                        int y=Arrays.binarySearch(group,roads[i][1]);
                        joinMask |=(1<<x)|(1<<y);
                    }
                }
                dp[mask|smask]=Math.min(dp[mask|smask],dp[mask]+minTotal[joinMask]);
            }
        }
        out.println(dp[(1<<4)-1]);
        return true;
    }
}
