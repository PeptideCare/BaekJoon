package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS와BFS_1260 {

    static int N;
    static int M;
    static int start;
    static boolean[] visited;
    static int [][] check;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        check = new int[1001][1001];
        visited = new boolean[1001];

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            check[x][y] = 1;
            check[y][x] = 1;
        }

        dfs(start);
        visited = new boolean[1001];

        sb.append(System.getProperty("line.separator"));

        bfs();

        System.out.println(sb);

    }

    static void dfs(int i) {

        visited[i] = true;
        sb.append(i).append(" ");

        for (int j=1; j<=N; j++) {
            if (check[i][j] == 1 && visited[j] == false) {
                dfs(j);
            }
        }
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        sb.append(start).append(" ");

        while (!q.isEmpty()) {
            int temp = q.poll();

            for (int i=1; i<=N; i++) {
                if (check[temp][i] == 1 && visited[i] == false) {
                    q.offer(i);
                    visited[i] = true;
                    sb.append(i).append(" ");
                }
            }
        }

    }

}
