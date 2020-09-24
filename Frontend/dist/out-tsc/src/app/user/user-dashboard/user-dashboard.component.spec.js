import { async, TestBed } from '@angular/core/testing';
import { UserDashboardComponent } from './user-dashboard.component';
describe('UserDashboardComponent', function () {
    var component;
    var fixture;
    beforeEach(async(function () {
        TestBed.configureTestingModule({
            declarations: [UserDashboardComponent]
        })
            .compileComponents();
    }));
    beforeEach(function () {
        fixture = TestBed.createComponent(UserDashboardComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });
    it('should create', function () {
        expect(component).toBeTruthy();
    });
});
//# sourceMappingURL=user-dashboard.component.spec.js.map