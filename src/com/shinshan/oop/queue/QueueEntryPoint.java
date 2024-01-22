package com.shinshan.oop.queue;

public class QueueEntryPoint {
    public static void main(String[] args) {
        QueueAvailable<Employee> queueEmps = new QueueMakingArray();
        queueEmps.enqueue(new Employee(150_000_000, "20150911","표민수"));
        queueEmps.enqueue(new Employee(120_000_000, "20170212","표강수"));
        queueEmps.enqueue(new Employee(145_000_000, "20161112","표만수"));

        System.out.println("첫번재 아이템 :  " + queueEmps.first());
        System.out.println("프론트 제거 : " + queueEmps.dequeue());
        System.out.println("큐가 비어있는가? : " + queueEmps.isEmpty());
        queueEmps.enqueue(new Employee(245_000_000, "20021117","강감찬"));
        queueEmps.enqueue(new Employee(345_000_000, "19980812","구디남"));
        System.out.println("큐 사이즈는  : " + queueEmps.size());
        System.out.println("프론트에서 삭제된 아이템 : " + queueEmps.dequeue());
    }
}
