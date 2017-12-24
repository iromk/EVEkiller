package pro.xite.game.evekiller.abstracts;


import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Matrix4;
import pro.xite.game.evekiller.abstracts.shapes.Rectangular;

/**
 * Утилита для работы с матрицами
 */
public class MatrixUtils {

    private MatrixUtils() {
    }

    /**
     * Расчёт матрицы перехода 4x4
     * @param mat итоговая матрица преобразований
     * @param src исходный квадрат
     * @param dst итоговый квадрат
     */
    public static void calcTransitionMatrix(Matrix4 mat, Rectangular src, Rectangular dst) {
        float scaleX = dst.getWidth() / src.getWidth();
        float scaleY = dst.getHeight() / src.getHeight();
        mat.idt().translate(dst.getCenterX(), dst.getCenterY(), 0f).scale(scaleX, scaleY, 1f)
                .translate(-src.getCenterX(), -src.getCenterY(), 0f);
    }

    /**
     * Расчёт матрицы перехода 3x3
     * @param mat итоговая матрица преобразований
     * @param src исходный квадрат
     * @param dst итоговый квадрат
     */
    public static void calcTransitionMatrix(Matrix3 mat, Rectangular src, Rectangular dst) {
        float scaleX = dst.getWidth() / src.getWidth();
        float scaleY = dst.getHeight() / src.getHeight();
        mat.idt().translate(dst.getCenterX(), dst.getCenterY()).scale(scaleX, scaleY)
                .translate(-src.getCenterX(), -src.getCenterY());
    }
}
