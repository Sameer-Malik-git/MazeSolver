package com.mycompany.maze_solver;

import java.awt.Color;
import java.awt.Graphics;
import java.util.*;
import javax.swing.JFrame;

public class maze_solver extends JFrame {
      private int[][] maze = {
                  { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                  { 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1 },
                  { 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1 },
                  { 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1 },
                  { 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1 },
                  { 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1 },
                  { 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1 },
                  { 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1 },
                  { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 9, 1 },
                  { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
      };
      public List<Integer> path = new ArrayList<>();

      public maze_solver() {
            setTitle("Maze Solver");
            setSize(1000, 720);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            maze_path.searchpath(maze, 1, 1, path);
            System.out.print(path);
      }

      @Override
      public void paint(Graphics g) {
            g.translate(150, 200);
            for (int i = 0; i < maze.length; i++) {
                  for (int j = 0; j < maze[0].length; j++) {
                        Color color;
                        switch (maze[i][j]) {
                              case 1:
                                    color = Color.black;
                                    break;
                              case 9:
                                    color = Color.red;
                                    break;
                              default:
                                    color = Color.white;
                                    break;
                        }

                        g.setColor(color);
                        g.fillRect(40 * j, 40 * i, 40, 40);
                        g.setColor(Color.blue);

                        g.drawRect(40 * j, 40 * i, 40, 40);
                  }
            }
            for (int i = 0; i < path.size(); i+=2) {
               int pathx=path.get(i);
               int pathy=path.get(i+1);
               System.out.print(" x cordinate "+pathx);
               System.out.print(" y cordinate "+pathy);
                        g.setColor(Color.green);
                        g.fillRect(40 * pathx, 40 * pathy, 20, 20);
                     
            }

      }

      public static void main(String[] args) {
            maze_solver view = new maze_solver();
            view.setVisible(true);
      }
}