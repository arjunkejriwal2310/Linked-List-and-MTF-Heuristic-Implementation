public class LinkedSimpleUSet<E> implements SimpleUSet<E>
{
    //create an instance variable of the LinkedSimpleList class
    private LinkedSimpleList<E> LinkedList;

    //constructor assigns an instance of LinkedSimpleList to the only instance variable in this class
    public LinkedSimpleUSet()
    {
        this.LinkedList = new LinkedSimpleList<E>();
    }

    //returns the size of the LinkedList by calling the instance method size() in the LinkedSimpleList class
    @Override
    public int size()
    {
        return this.LinkedList.size();
    }

    //returns whether the LinkedList is empty by calling the instance method isEmpty() in the LinkedSimpleList class
    @Override
    public boolean isEmpty()
    {
        return this.LinkedList.isEmpty();
    }

    //first checks whether the object to be added doesn't already exist in the set and then adds the object to the end of the LinkedList. Returns whether the object has been added or not.
    @Override
    public boolean add(E x)
    {
        if(this.find(x) == null)
        {
            //Calling add method from LinkedSimpleList
            this.LinkedList.add(this.size(), x);
        }
        else if(this.find(x).equals(x))
        {
            return false;
        }

        return true;
    }

    //first checks whether the object exists in the set and then removes and returns the object from the set
    @Override
    public E remove(E x)
    {
        if(this.find(x) == null)
        {
            return null;
        }
        if(this.find(x).equals(x))
        {
            int index = giveIndex(x);
            //Calling remove method from LinkedSimpleList
            return this.LinkedList.remove(index);
        }

        return null;
    }

    //returns the object if the object is found in the set. Returns null is the object is not found
    @Override
    public E find(E x)
    {
        for (int i = 0; i < this.size(); i++)
        {
            //Calling get method from LinkedSimpleList
            if (this.LinkedList.get(i).equals(x))
            {
                return x;
            }
        }

        return null;
    }

    //Returns the index/position of the object in the set. Returns -1 if the object is not found
    public int giveIndex(E x)
    {
        for (int i = 0; i < this.size(); i++)
        {
            if (this.LinkedList.get(i).equals(x))
            {
                return i;
            }
        }

        return -1;
    }

    //returns the pointer to the LinkedList object stored in the only instance variable of the class
    public LinkedSimpleList<E> getLinkedList()
    {
        return this.LinkedList;
    }
}



