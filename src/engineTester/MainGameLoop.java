package engineTester;

import Shaders.StaticShader;
import org.lwjgl.opengl.Display;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.RawModel;
import renderEngine.Renderer;

public class MainGameLoop {

    public static  void main(String[] args){

        DisplayManager.createDisplay();
        Loader loader = new Loader();
        Renderer renderer = new Renderer();
        StaticShader shader = new StaticShader();

        float[] vertices = {
                -0.5f, 0.5f, 0,
                -0.5f, -0.5f, 0,
                0.5f, -0.5f, 0,
                0.5f, 0.5f, 0
        };

        int[] indices = {

                0,1,3,  //Top Left Triangle(V0,V1,V3)
                3,1,2   //bOTTOM RIGHT TRIANGLE (v3,v1,v2)
        };

        RawModel model = loader.loadToVAO(vertices, indices);

        while(!Display.isCloseRequested()){

            //game logic

            renderer.prepare();
            shader.start();
            renderer.render(model);
            shader.stop();
            DisplayManager.updateDisplay();
        }

        shader.cleanUp();
        loader.cleanUp();
        DisplayManager.closeDisplay();

    }
}




