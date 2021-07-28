(ns com.dpisarenko.camundarepl
  (:import
    (org.camunda.bpm.engine.delegate DelegateExecution)
    )
  )

(defn add
  [a b]
  (+ a b))

(defn test
  [delEx]
  (doto
   delEx
    (.setVariable "Heyo" "This was set in Clojure")
    )
  )

(defn sample-function
  [delEx]
  (doto
    delEx
    (.setVariable "MY_VAR_NAME"
                  "Some var value")
    )
  )