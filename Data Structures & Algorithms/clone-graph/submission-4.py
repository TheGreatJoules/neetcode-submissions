"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if not node:
            return None
        graph = {}
        graph[node] = Node(node.val)
        queue = deque([node])
        while queue:
            current = queue.popleft()
            for neighbor in current.neighbors:
                if neighbor not in graph:
                    queue.append(neighbor)
                    graph[neighbor] = Node(neighbor.val)
                graph[current].neighbors.append(graph[neighbor])
        return graph[node]

