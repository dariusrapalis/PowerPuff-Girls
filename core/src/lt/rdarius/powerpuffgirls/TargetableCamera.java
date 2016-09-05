package lt.rdarius.powerpuffgirls;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;

public class TargetableCamera extends OrthographicCamera {
	
	private float margin = 0;
	private float targetWidth, targetHeight;
	
	public TargetableCamera(float width, float height)
	{
		setDimentions(width, height);
	}
	
	public void setDimentions(float width, float height)
	{
		targetWidth = width;
		targetHeight = height;
		
		updateViewport();
	}
	
	public float getTargetWidth()
	{
		return targetWidth;
	}
	
	public float getTargetHeight()
	{
		return targetHeight;
	}
	
	public void updateViewport()
	{
		float workWidth = targetWidth + margin * 2;
		float workHeight = targetHeight + margin * 2;
		
		float ratioDisplay = Gdx.graphics.getWidth() / (float)Gdx.graphics.getHeight();
		float ratioTarget = workWidth / workHeight;
		
		if (ratioDisplay > ratioTarget)
		{
			this.viewportHeight = workHeight;
			this.viewportWidth = workHeight * ratioDisplay;
		}
		else
		{
			this.viewportWidth = workWidth;
			this.viewportHeight = workWidth * (1 / ratioDisplay);
		}
		this.update();
	}
	
	public void setMargin(float margin)
	{
		this.margin = margin;
		updateViewport();
	}
	
	public float getMargin()
	{
		return this.margin;
	}
	
	public void setPosition(float x, float y)
	{
		this.position.x = x;
		this.position.y = y;
		this.update();
	}
	
	public float getProjectedX(float x)
	{
		return this.position.x + viewportWidth * (x / Gdx.graphics.getWidth()) - viewportWidth/2;
	}

	public float getProjectedY(float y)
	{
		return this.position.y + viewportHeight * (y / Gdx.graphics.getHeight()) + viewportHeight/2;
	}
	
	public Vector2 getProjectedPoint(Vector2 point)
	{
		return new Vector2(getProjectedX(point.x), getProjectedY(point.y));
	}
}
