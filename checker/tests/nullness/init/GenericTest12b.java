import org.checkerframework.checker.nullness.qual.Nullable;
import org.checkerframework.checker.nullness.qual.Raw;
import org.checkerframework.checker.initialization.qual.UnderInitialization;

class GenericTest12b {
    class Cell<T1 extends @Nullable Object> {}

    class Node<CONTENT extends @Nullable Object> {
        public Node(Cell<CONTENT> userObject) { }
        void nodecall(@Raw @UnderInitialization Node<CONTENT> this, Cell<CONTENT> userObject) {}
    }

    class RootNode extends Node<Void> {
        public RootNode() {
            super(new Cell<Void>());
            call(new Cell<Void>());
            nodecall(new Cell<Void>());
        }
        void call(@Raw @UnderInitialization RootNode this, Cell<Void> userObject) {}
    }
}
