package com.cestiamo.cestiamo.domain;

import javax.persistence.*;

public enum EnumTipoP {
        UNOvUNO("1 vs 1"),
        DUEvsDUE("2 vs 2"),
        TREvsTRE("3 vs 3"),
        QUATTROvsQUATTRO("4 vs 4"),
        CINQUEvsCINQUE("5 vs 5");

        public final String label;

        private EnumTipoP(String label) {
                this.label = label;
        }

}