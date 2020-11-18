#include <bits/stdc++.h>
#define lli long long int
#define endl '\n'
#define deb(x) cout << #x << " = " << x << endl
#define deb2(x, y) cout << #x << " = " << x << ", " << #y << " = " << y << endl
#define deb3(x, y, z) cout << #x << " = " << x << ", " << #y << " = " << y << ", " << #z << " = " << z << endl
#define fastio 	ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);

using namespace std;

class Edge {
public:
    int u, v, w;
};

class Node {
public:
    int parent, rank;
};

vector<Node> dsu;
vector<Edge> mst;

int find(int v) {
    return (dsu[v].parent == -1) ? v : find(dsu[v].parent);
}

void unionSet(int a, int b) {
    if (dsu[a].rank > dsu[b].rank)
        dsu[b].parent = a;
    else if (dsu[a].rank < dsu[b].rank)
        dsu[a].parent = b;
    else {
        dsu[a].parent = b;
        dsu[b].rank++;
    }
}

bool sortWeights(Edge a, Edge b) {
    return (a.w <= b.w) ? true : false;
}

void kruskals(vector<Edge>& edges, int n, int m) {

    sort(edges.begin(), edges.end(), sortWeights);

    int i = 0, j = 0;
    while(i < n - 1 && j < m) {
        int a = find(edges[j].u);
        int b = find(edges[j].v);

        if (a == b) {
            j++;
            continue;
        }

        unionSet(a, b);
        mst.push_back(edges[j]);
        i++;
    }

    cout << "MST: " << endl;
    for (auto e: mst)
        deb3(e.u, e.v, e.w);
    cout << endl;
}

int main()
{
//6 10
//0 1 1
//1 3 1
//2 4 1
//0 2 2
//2 3 2
//3 4 2
//1 2 3
//1 4 3
//4 5 3
//3 5 3
	fastio;

    int n , m;
    cin >> n >> m;

    dsu.resize(n);

    for (int i = 0; i < n; i++) {
        dsu[i].parent = -1;
        dsu[i].rank = 0;
    }

    vector<Edge> edges;
    Edge temp;
    for (int i = 0; i < m; i++) {
        int u, v, w;
        cin >> u >> v >> w;

        temp.u = u;
        temp.v = v;
        temp.w = w;

        edges.push_back(temp);
    }

    kruskals(edges, n, m);

	return 0;
}


