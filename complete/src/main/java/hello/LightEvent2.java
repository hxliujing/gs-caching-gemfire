package hello;

import org.springframework.context.ApplicationEvent;

public class LightEvent2 extends ApplicationEvent{
    private LightColorEnum lightColor;
    public LightEvent2(Object source) {
        super(source);
    }
    public LightEvent2(Object source, LightColorEnum lightColor) {
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
        BBB("bbb"), XXX("xxx"), AAA("aaa");

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
