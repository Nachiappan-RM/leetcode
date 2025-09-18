class Task {
    int userId;
    int taskId;
    int priority;

    public Task(int userId, int taskId, int priority) {
        this.userId = userId;
        this.taskId = taskId;
        this.priority = priority;
    }
}

class TaskManager {
    private TreeSet<Task> taskSet;
    private Map<Integer, Task> idMap;

    public TaskManager(List<List<Integer>> tasks) {
        Comparator<Task> cmp = (a,b) -> {
            if(a.priority != b.priority) {
                return b.priority - a.priority;
            }
            return b.taskId - a.taskId;
        };
        taskSet = new TreeSet<>(cmp);
        idMap = new HashMap<>();

        for(List<Integer> triple: tasks) {
            int u = triple.get(0);
            int t = triple.get(1);
            int p = triple.get(2);

            Task task = new Task(u, t, p);
            taskSet.add(task);
            idMap.put(t, task);
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        Task task = new Task(userId, taskId, priority);
        taskSet.add(task);
        idMap.put(taskId, task);
    }
    
    public void edit(int taskId, int newPriority) {
        Task task = idMap.get(taskId);
        taskSet.remove(task);
        task.priority = newPriority;
        taskSet.add(task);
    }
    
    public void rmv(int taskId) {
        Task task = idMap.get(taskId);
        taskSet.remove(task);
        idMap.remove(taskId);
    }
    
    public int execTop() {
        if(taskSet.isEmpty()) {
            return -1;
        }
        Task top = taskSet.pollFirst();
        idMap.remove(top.taskId);
        return top.userId;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */