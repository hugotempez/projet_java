package fr.itii25.models.dao;

public enum DB {
    SAKILA() {
        @Override
        public String getValue() {
            return "input_sakila";
        }
    },
    POSTGRES() {
        @Override
        public String getValue() {
            return "output_postgres";
        }
    };

    public abstract String getValue();
}
