#include <bits/stdc++.h>
#define lli long long int
#define endl '\n'
#define deb(x) cout << #x << " = " << x << endl
#define deb2(x, y) cout << #x << " = " << x << ", " << #y << " = " << y << endl
#define deb3(x, y, z) cout << #x << " = " << x << ", " << #y << " = " << y << ", " << #z << " = " << z << endl
#define fastio 	ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);

using namespace std;

const int n = 5;
vector<int> G[n];
bool visited[n];
stack<int> order;

void dfs(int u, bool first) {
    visited[u] = true;

    for (int v: G[u]) {
        if (!visited[v])
            dfs(v, first);
    }

    if (first)
    order.push(u);
}


void reverseEdges() {
    vector<int> adj[n];
    for (int v = 0; v < n; v++) {
        for (auto i = G[v].begin(); i != G[v].end(); i++) {
            adj[*i].push_back(v);
        }
    }
    for (int i = 0; i < n; i++) {
        G[i].clear();
    }

    for (int i = 0; i < n; i++) {
        for (int edge: adj[i]) {
            G[i].push_back(edge);
        }
    }
}

int main()
{
	fastio;

    int m;
    cin >> m;

    for (int i = 0; i < m; i++) {
        int a, b;
        cin >> a >> b;

        G[a].push_back(b);
    }

    int x;
    cin >> x;
    dfs(x, true);

//    cout << "Stack: ";
//    while(!order.empty()) {
//        cout << order.top() << " ";
//        order.pop();
//    }
//    cout << endl;

    reverseEdges();
    memset(visited, false, sizeof(visited));

    int comps = 0;
    while(!order.empty()) {
        int curr = order.top();
        order.pop();

        if (!visited[curr]) {
            dfs(curr, false);
            comps++;
        }
    }

    cout << "SCC: " << comps << endl;

	return 0;
}


