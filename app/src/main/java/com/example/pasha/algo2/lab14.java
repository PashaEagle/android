package com.example.pasha.algo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Math.min;
import static java.util.Arrays.fill;

public class lab14 extends AppCompatActivity {

    Button btn_create;
    Button btn_addEdge;
    Button btn_calc;

    EditText editTextNodes;
    EditText editTextStart;
    EditText editTextFrom;
    EditText editTextTo;
    EditText editTextLength;

    TextView textViewGG;

    int INF = Integer.MAX_VALUE / 2; // "Бесконечность"
    int vNum; // количество вершин
    int[][] graph; // матрица смежности
    int nowEdges;
    int maxEdges;
    int startFrom;
    int[] dist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab14);

        btn_create = (Button)findViewById(R.id.btn_create);
        btn_addEdge = (Button)findViewById(R.id.btn_addEdge);
        btn_calc = (Button)findViewById(R.id.btn_calc);

        editTextNodes = (EditText) findViewById(R.id.editTextNodes);
        editTextStart = (EditText) findViewById(R.id.editTextStart);
        editTextFrom = (EditText) findViewById(R.id.editTextFrom);
        editTextTo = (EditText) findViewById(R.id.editTextTo);
        editTextLength = (EditText) findViewById(R.id.editTextLength);

        textViewGG = (TextView) findViewById(R.id.textViewGG);

        btn_addEdge.setVisibility(View.INVISIBLE);
        btn_calc.setVisibility(View.INVISIBLE);
        editTextFrom.setVisibility(View.INVISIBLE);
        editTextTo.setVisibility(View.INVISIBLE);
        editTextLength.setVisibility(View.INVISIBLE);

        nowEdges = 0;
        maxEdges = 0;

        textViewGG.setText("");
    }



    public void btnCreateClick(View view){
        try{

            vNum = Integer.parseInt(editTextNodes.getText().toString());
            startFrom = Integer.parseInt(editTextStart.getText().toString());

            if (startFrom > vNum){
                Toast.makeText(lab14.this, "Error, node doesnt exists", Toast.LENGTH_SHORT).show();
                return;
            }

            graph = new int[vNum][vNum];
            btn_addEdge.setVisibility(View.VISIBLE);
            btn_calc.setVisibility(View.VISIBLE);
            editTextFrom.setVisibility(View.VISIBLE);
            editTextTo.setVisibility(View.VISIBLE);
            editTextLength.setVisibility(View.VISIBLE);
            btn_create.setEnabled(false);
            editTextNodes.setEnabled(false);
            editTextStart.setEnabled(false);

            for (int i = 0; i < vNum; ++i){
                for (int j = 0; j < vNum; ++j){
                    graph[i][j] = INF;
                }
            }

        }catch (Exception e){
            Toast.makeText(lab14.this, "Error !", Toast.LENGTH_SHORT).show();

        }
    }

    public void btnAddEdgeClick(View view){
        try{
            maxEdges = 0;
            for(int i = vNum - 1; i > 0; --i) maxEdges += i;
            if (nowEdges >= maxEdges){
                Toast.makeText(lab14.this, "You cannot add more edges", Toast.LENGTH_SHORT).show();
                editTextFrom.setEnabled(false);
                editTextTo.setEnabled(false);
                editTextLength.setEnabled(false);
                return;
            }

            int from = Integer.parseInt(editTextFrom.getText().toString());
            int to = Integer.parseInt(editTextTo.getText().toString());
            int length = Integer.parseInt(editTextLength.getText().toString());

            if (length < 1){
                Toast.makeText(lab14.this, "Too small length", Toast.LENGTH_SHORT).show();
                return;
            }

            if (from < 1 || from > vNum || to < 1 || to > vNum){
                Toast.makeText(lab14.this, "Node doesnt exists", Toast.LENGTH_SHORT).show();
                return;
            }

            if(from == to){
                graph[from - 1][to - 1] = 0;
            }
            else{
                graph[from-1][to-1] = length;
                graph[to-1][from-1] = length;
            }

            Toast.makeText(lab14.this, "Successfully added", Toast.LENGTH_SHORT).show();
            editTextFrom.setText("");
            editTextTo.setText("");
            editTextLength.setText("");
            ++nowEdges;

        }catch (Exception e){
            Toast.makeText(lab14.this, "Error !", Toast.LENGTH_SHORT).show();

        }
    }

    public void btnCalcClick(View view){
        dijkstra(startFrom - 1);
        textViewGG.setText("");
        for (int i = 0; i < vNum; ++i){
            textViewGG.append("Distance from " + startFrom + " to " + (i + 1) + " = " + dist[i] + "\n");

        }
    }

             /* Алгоритм Дейкстры за O(V^2) */

    void dijkstra(int start) {
         boolean[] used = new boolean [vNum]; // массив пометок
         dist = new int [vNum]; // массив расстояния. dist[v] = минимальное_расстояние(start, v)


         fill(dist, INF); // устанаавливаем расстояние до всех вершин INF
         dist[start] = 0; // для начальной вершины положим 0

         for (;;) {
             int v = -1;
             for (int nv = 0; nv < vNum; nv++) // перебираем вершины
                     if (!used[nv] && dist[nv] < INF && (v == -1 || dist[v] > dist[nv])) // выбираем самую близкую непомеченную вершину
                         v = nv;
            if (v == -1) break; // ближайшая вершина не найдена
            used[v] = true; // помечаем ее
            for (int nv = 0; nv < vNum; nv++)
                   if (!used[nv] && graph[v][nv] < INF) // для всех непомеченных смежных
                       dist[nv] = min(dist[nv], dist[v] + graph[v][nv]); // улучшаем оценку расстояния (релаксация)
         }
    }
}