package br.com.thiagopagonha.labirinthos.factory;

import java.io.IOException;
import java.io.InputStream;

import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.ITexture;
import org.andengine.opengl.texture.TextureManager;
import org.andengine.opengl.texture.bitmap.BitmapTexture;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TextureRegionFactory;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.adt.io.in.IInputStreamOpener;

import android.content.res.AssetManager;
import android.util.Log;

/**
 * Fábrica geradora de srites
 * 
 * @author Thiago Pagonha
 * @version Mai/2013
 *
 */
public class SpriteFactory {

	private static final String TAG = "SpriteFactory";
	
	private VertexBufferObjectManager vertexBufferObjectManager;
	private TextureManager textureManager;
	private AssetManager assetManager;
	
	public SpriteFactory(VertexBufferObjectManager vertexBufferObjectManager, TextureManager textureManager, AssetManager assetManager) {
		this.vertexBufferObjectManager = vertexBufferObjectManager;
		this.textureManager = textureManager;
		this.assetManager = assetManager;
	}
	
	/**
	 * Cria o determinado sprite nas posições
	 * @param fileName
	 * @param x
	 * @param y
	 * @return
	 */
	public Sprite createSprite(final String fileName, float x, float y) {
		
		try {
			ITexture texture;
			ITextureRegion textureRegion;
            texture = new BitmapTexture(textureManager, new IInputStreamOpener() {
                @Override
                public InputStream open() throws IOException {
                    return assetManager.open("gfx/"+fileName);
                }
            });

            texture.load();
            textureRegion = TextureRegionFactory.extractFromTexture(texture);
            
            return new Sprite(x,y,textureRegion,vertexBufferObjectManager);
            
        } catch (IOException e) {
    		Log.d(TAG, "Erro ao carregar Sprite", e);
        }
		return null;
	}
	
}
