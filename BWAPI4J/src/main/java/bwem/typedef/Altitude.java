package bwem.typedef;

import bwem.util.IWrappedInteger;
import java.util.Objects;

/**
 * Immutable wrapper of the integer primitive to satisfy
 * the original C++ definition:
 * defs.h:54:typedef int16_t altitude_t;
 *
 * Type of the altitudes in pixels.
 */
public final class Altitude implements IWrappedInteger<Altitude>, Comparable<Altitude> {

    private final int val;

    public Altitude(int val) {
        this.val = val;
    }

    public Altitude(Altitude altitude) {
        this.val = altitude.val;
    }

    @Override
    public Altitude add(Altitude that) {
        return new Altitude(this.val + that.val);
    }

    @Override
    public Altitude add(int val) {
        return new Altitude(this.val + val);
    }

    @Override
    public Altitude subtract(Altitude that) {
        return new Altitude(this.val - that.val);
    }

    @Override
    public Altitude subtract(int val) {
        return new Altitude(this.val - val);
    }

    @Override
    public int intValue() {
        return this.val;
    }

    @Override
    public int compareTo(Altitude that) {
        int lhs = this.val;
        int rhs = that.val;
        return (lhs < rhs) ? -1 : (lhs > rhs) ? 1 : 0;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        } else if (!(object instanceof Altitude)) {
            return false;
        } else {
            Altitude that = (Altitude) object;
            return (this.val == that.val);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.val);
    }

}