package hello;

import org.springframework.context.ApplicationEvent;

public class LightEvent extends ApplicationEvent{
    private LightColorEnum lightColor;
    public LightEvent(Object source) {
        super(source);
    }
    public LightEvent(Object source, LightColorEnum lightColor) {
        super(source);
        this.setLightColor(lightColor);
    }
    public void setLightColor(LightColorEnum lightColor) {
        this.lightColor = lightColor;
    }

    public LightColorEnum getLightColor() {
        return lightColor;
    }

    public enum LightColorEnum {
        RED("stop"), YELLOW("wait"), GREEN("go");

        private String message;

        private LightColorEnum(String message){
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
