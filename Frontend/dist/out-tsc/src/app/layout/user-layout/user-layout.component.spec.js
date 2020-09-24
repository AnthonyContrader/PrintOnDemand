import { async, TestBed } from '@angular/core/testing';
import { UserLayoutComponent } from './user-layout.component';
describe('UserLayoutComponent', function () {
    var component;
    var fixture;
    beforeEach(async(function () {
        TestBed.configureTestingModule({
            declarations: [UserLayoutComponent]
        })
            .compileComponents();
    }));
    beforeEach(function () {
        fixture = TestBed.createComponent(UserLayoutComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });
    it('should create', function () {
        expect(component).toBeTruthy();
    });
});
//# sourceMappingURL=user-layout.component.spec.js.map